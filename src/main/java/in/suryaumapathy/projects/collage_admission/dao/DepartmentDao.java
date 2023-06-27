package in.suryaumapathy.projects.collage_admission.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.suryaumapathy.projects.collage_admission.exception.PersistanceException;
import in.suryaumapathy.projects.collage_admission.model.Department;
import in.suryaumapathy.projects.collage_admission.utils.ConnectionUtil;

public class DepartmentDao {

	public Department[] getAllDepartments() throws PersistanceException {
		Connection conn;
		PreparedStatement ps;

		List<Department> departmentList = new ArrayList<Department>();

		try {

			conn = ConnectionUtil.getConnection();

			String query = "SELECT `id`, `name`  FROM departments;";
			ps = conn.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				departmentList.add(toRow(rs));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new PersistanceException(e);

		}
		return (Department[]) departmentList.toArray();

	}

	public Department getDepartment(int departmentId) throws PersistanceException {

		Connection conn;
		PreparedStatement ps;
		Department departmentDetails = null;

		try {
			conn = ConnectionUtil.getConnection();
			String query = "SELECT ( `id`, `name` ) FROM departments WHERE id = ?;";
			ps = conn.prepareStatement(query);
			ps.setInt(1, departmentId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				departmentDetails = toRow(rs);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new PersistanceException(e);

		}
		return departmentDetails;

	}

	public Department getDepartment(String departmentName) throws PersistanceException {
		Connection conn;
		PreparedStatement ps;
		Department departmentDetails = null;

		try {
			conn = ConnectionUtil.getConnection();
			String query = "SELECT ( `id`, `name` ) FROM departments WHERE name = ? ;";
			ps = conn.prepareStatement(query);
			ps.setString(1, departmentName);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				departmentDetails = toRow(rs);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new PersistanceException(e);

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
