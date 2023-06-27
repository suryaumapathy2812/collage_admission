package in.suryaumapathy.projects.collage_admission.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import in.suryaumapathy.projects.collage_admission.dto.StudentDepartmentDetailsDto;
import in.suryaumapathy.projects.collage_admission.exception.PersistanceException;
import in.suryaumapathy.projects.collage_admission.model.StudentDepartment;
import in.suryaumapathy.projects.collage_admission.utils.ConnectionUtil;

public class StudentDepartmentDao {

	public StudentDepartmentDao() {
	}

	/**
	 * 
	 * @param studentId
	 * @return
	 * @throws Exception
	 */
	public StudentDepartment findByStudentId(int studentId) throws PersistanceException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		StudentDepartment studentDept = null;

		try {
			conn = ConnectionUtil.getConnection();

			String query = "SELECT `id`, `student_id`, `department_id`, `active` FROM student_class WHERE student_id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, studentId);
			rs = ps.executeQuery();

			if (rs.next()) {
				studentDept = toRow(rs);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new PersistanceException(e);
		} finally {
			ConnectionUtil.close(conn, ps, rs);
		}

		return studentDept;

	}

	/**
	 * 
	 * @param departmentId
	 * @return
	 * @throws Exception
	 */
	public List<StudentDepartment> findByDepartmentId(int departmentId) throws PersistanceException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<StudentDepartment> departmentStudents = new ArrayList<StudentDepartment>();

		try {
			conn = ConnectionUtil.getConnection();

			String query = "SELECT  `id`, `student_id`, `department_id`, `active`  FROM student_class WHERE department_id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, departmentId);

			rs = ps.executeQuery();

			while (rs.next()) {
				departmentStudents.add(toRow(rs));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new PersistanceException(e);
		} finally {
			ConnectionUtil.close(conn, ps, rs);
		}

		return departmentStudents;

	}

	/**
	 * 
	 * @param departmentName
	 * @return
	 * @throws Exception
	 */
	public List<StudentDepartment> findByDepartmentName(String departmentName) throws PersistanceException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<StudentDepartment> departmentStudents = new ArrayList<>();

		try {
			conn = ConnectionUtil.getConnection();

			String query = "SELECT  `id`, `student_id`, `department_id`, `active` FROM student_class WHERE department_id = ( select id from departments where name=?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, departmentName);
			rs = ps.executeQuery();

			while (rs.next()) {
				departmentStudents.add(toRow(rs));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new PersistanceException(e);
		} finally {
			ConnectionUtil.close(conn, ps, rs);
		}

		return departmentStudents;

	}

	/**
	 * 
	 * @param studentId
	 * @param departmentId
	 * @return
	 * @throws Exception
	 */
	public boolean update(int studentId, int departmentId) throws PersistanceException {

		Connection conn = null;
		PreparedStatement ps = null;

		boolean status = false;

		System.out.println("updateStudentDepartment ==========================>");
		System.out.println("studentId: " + studentId + " departmentId: " + departmentId);

		try {
			conn = ConnectionUtil.getConnection();
			String query = "UPDATE student_class SET department_id = ? WHERE student_id = ? ;";
			ps = conn.prepareStatement(query);
			ps.setInt(1, departmentId);
			ps.setInt(2, studentId);

			System.out.println("before executeUpdate ==========================>");
			int rowsAffected = ps.executeUpdate();

			if (rowsAffected == 0) {
				status = false;
			} else {
				status = true;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new PersistanceException(e);
		} finally {
			ConnectionUtil.close(conn, ps);
		}

		return status;

	}

	/**
	 * 
	 * @param studentId
	 * @param departmentName
	 * @return
	 * @throws Exception
	 */
	public boolean update(int studentId, String departmentName) throws PersistanceException {

		Connection conn = null;
		PreparedStatement ps = null;

		boolean status = false;

		try {
			conn = ConnectionUtil.getConnection();

			String query = "UPDATE student_class set department_id = (select id from departments where name = ? ) where student_id = ?";

			ps = conn.prepareStatement(query);
			ps.setString(1, departmentName);
			ps.setInt(2, studentId);

			int rowsAffected = ps.executeUpdate();
			System.out.println("Affected rows: ==========================> " + rowsAffected);

			if (rowsAffected == 0) {
				status = false;
			} else {
				status = true;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new PersistanceException(e);
		} finally {
			ConnectionUtil.close(conn, ps);
		}

		return status;

	}

	/**
	 * 
	 * @param studentId
	 * @return
	 * @throws Exception
	 */
	public boolean updateStatus(int studentId) throws PersistanceException {

		Connection conn = null;
		PreparedStatement ps = null;

		boolean status = false;

		try {
			conn = ConnectionUtil.getConnection();
			String query = "update student_class set active=0 where student_id = ?;";
			ps = conn.prepareStatement(query);
			ps.setInt(1, studentId);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Affected rows: ==========================> " + rowsAffected);

			if (rowsAffected == 0) {
				status = false;
			} else {
				status = true;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new PersistanceException(e);
		} finally {
			ConnectionUtil.close(conn, ps);
		}

		return status;

	}

	/**
	 * 
	 * @param departmentId
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Integer>> count() throws PersistanceException {

		Connection conn = null;
		PreparedStatement ps = null;
		List<Map<String, Integer>> response = new ArrayList<>();

		try {

			conn = ConnectionUtil.getConnection();
			String query = "select department_id, count(*) as no_of_students from student_class sc, departments d where sc.department_id = d.id and sc.active=1 group by department_id";
			ps = conn.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Map<String, Integer> map = new HashMap<>();
				map.put("departmentId", rs.getInt("department_id"));
				map.put("noOfStudents", rs.getInt("no_of_students"));

				response.add(map);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new PersistanceException(e);
		} finally {
			ConnectionUtil.close(conn, ps);
		}
		return response;

	}

	public List<StudentDepartmentDetailsDto> findStudentDetails() throws PersistanceException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<StudentDepartmentDetailsDto> response = new ArrayList<>();

		try {
			String query = "select s.id, s.name,  sc.department_id from students s, student_class sc where s.id = sc.student_id";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {

				StudentDepartmentDetailsDto map = new StudentDepartmentDetailsDto();

				map.setId(rs.getInt("id"));
				map.setDepartmentId(rs.getInt("department_id"));
				map.setName(rs.getString("name"));

				response.add(map);
			}
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new PersistanceException(e);

		} finally {
			ConnectionUtil.close(conn, ps, rs);
		}

		return response;

	}

	public String findStudentDepartmentByEmail(String email) throws PersistanceException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String response = null;

		try {

			String query = "SELECT d.name FROM departments d WHERE d.id =  ( SELECT sc.department_id  FROM student_class sc WHERE sc.student_id = ( SELECT id FROM students WHERE email=?))";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, email);

			rs = ps.executeQuery();

			if (rs.next()) {
				response = rs.getString("name");
			} 

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new PersistanceException(e.getMessage());
		} finally {
			ConnectionUtil.close(conn, ps, rs);
		}

		return response;
	}

	public List<Object> findAllStudentsNotEnrolled() throws Exception {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Object> response = new ArrayList<>();

		try {

			String sql = "select * from students where id not in ( select student_id from student_class )";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			if (rs.next()) {

				Map<String, String> obj = new HashMap<>();
				obj.put("id", rs.getInt("id") + "");
				obj.put("name", rs.getString("name"));
				obj.put("email", rs.getString("email"));
				obj.put("mobile_no", rs.getLong("mobile_no") + "");
				obj.put("gender", rs.getString("gender"));

				response.add(obj);
			}

			return response;

		} catch (SQLException e) {
			throw new PersistanceException("Failed to access student details");
		} finally {
			ConnectionUtil.close(conn, ps, rs);
		}

	}

	public List<Object> FindAllStudentWithClassName() throws Exception {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Object> response = new ArrayList<>();

		try {

			String sql = "select s.id, s.name, s.email, sc.department_id from students s left outer join student_class sc on s.id = sc.student_id";

			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				Map<String, String> obj = new HashMap<>();
				obj.put("id", "" + rs.getInt("id"));
				obj.put("name", rs.getString("name"));
				obj.put("email", rs.getString("email"));
				obj.put("departmentId", "" + rs.getInt("department_id"));

				response.add(obj);
			}

			return response;

		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Failed retieve student details");
		} finally {
			ConnectionUtil.close(conn, ps, rs);
		}

	}

	/**
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private StudentDepartment toRow(ResultSet rs) throws SQLException {

		StudentDepartment studentDept = new StudentDepartment();
		studentDept.setId(rs.getInt("id"));
		studentDept.setStudentId(rs.getInt("student_id"));
		studentDept.setDepartmentId(rs.getInt("department_id"));
		studentDept.setActive(rs.getBoolean("active"));
		return studentDept;

	}

}
