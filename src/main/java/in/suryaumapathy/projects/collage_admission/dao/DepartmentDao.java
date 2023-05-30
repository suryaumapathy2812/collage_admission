package in.suryaumapathy.projects.collage_admission.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.suryaumapathy.projects.collage_admission.model.Department;
import in.suryaumapathy.projects.collage_admission.utils.ConnectionUtil;

public class DepartmentDao {

	Connection conn;
	PreparedStatement ps;
	Statement stmt;

	public DepartmentDao() throws Exception {
		conn = ConnectionUtil.getConnection();
		stmt = conn.createStatement();
	}

	public Department[] getAllDepartments() throws Exception {

		List<Department> departmentList = new ArrayList<Department>();

		try {
			String query = "SELECT `id`, `name`  FROM departments;";
			PreparedStatement stmt = conn.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				departmentList.add(toRow(rs));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new Exception(e);

		}
		return (Department[]) departmentList.toArray();

	}

	public Department getDepartment(int departmentId) throws Exception {

		Department departmentDetails = null;

		try {
			String query = "SELECT ( `id`, `name` ) FROM departments WHERE id = ?;";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, departmentId);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				departmentDetails = toRow(rs);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new Exception(e);

		}
		return departmentDetails;

	}

	public Department getDepartment(String departmentName) throws Exception {

		Department departmentDetails = null;

		try {
			String query = "SELECT ( `id`, `name` ) FROM departments WHERE name = ? ;";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, departmentName);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				departmentDetails = toRow(rs);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new Exception(e);

		}
		return departmentDetails;

	}

	private Department toRow(ResultSet rs) throws SQLException {

		Department departmentDetails = new Department();
		departmentDetails.setId(rs.getInt("id"));
		departmentDetails.setName(rs.getString("name"));
		return departmentDetails;

	}

}
