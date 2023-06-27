package in.suryaumapathy.projects.collage_admission.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.suryaumapathy.projects.collage_admission.exception.PersistanceException;
import in.suryaumapathy.projects.collage_admission.model.Student;
import in.suryaumapathy.projects.collage_admission.utils.ConnectionUtil;

public class StudentDao {


	public Student getStudentProfile(String email, String password) throws PersistanceException {
		Student studentDetails = new Student();
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "SELECT `id`, `name`, `email`, `mobile_no`, `password`, `gender`, `dob` FROM students WHERE `email` = ? AND `password` = ? ;";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				studentDetails = toRow(rs);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new PersistanceException(e);
		}
		return studentDetails;
	}
	
	
	public Student getStudentProfile(int id) throws PersistanceException {
		Student studentDetails = new Student();
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "SELECT `id`, `name`, `email`, `mobile_no`, `password`, `gender`, `dob` FROM students WHERE `id` = ? ";
			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				studentDetails = toRow(rs);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new PersistanceException(e);
		}
		return studentDetails;
	}

	private Student toRow(ResultSet rs) throws SQLException {
		Student studentDetails = new Student();
		studentDetails.setId(rs.getInt("id"));
		studentDetails.setName(rs.getString("name"));
		studentDetails.setEmail(rs.getString("email"));
		studentDetails.setMobileNo(rs.getLong("mobile_no"));
		studentDetails.setPassword(rs.getString("password"));
		studentDetails.setDob(rs.getDate("dob"));

		String gender = rs.getString("gender");
		if (gender != null) {
			studentDetails.setGender(gender.charAt(0));
		}

		return studentDetails;
	}

}
