package in.suryaumapathy.projects.collage_admission.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.suryaumapathy.projects.collage_admission.model.Student;
import in.suryaumapathy.projects.collage_admission.utils.ConnectionUtil;

public class StudentDao {

	Connection conn;
	PreparedStatement ps;
	Statement stmt;

	public StudentDao() throws Exception {
		conn = ConnectionUtil.getConnection();
		stmt = conn.createStatement();
	}

	public Student getStudentProfile(String email, String password) throws Exception {
		Student studentDetails = new Student();
		try {
			String query = "SELECT `id`, `name`, `email`, `mobile_no`, `password`, `gender`, `dob` FROM students WHERE `email` = ? AND `password` = ? ;";
			PreparedStatement stmt = conn.prepareStatement(query);

			stmt.setString(1, email);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				studentDetails = toRow(rs);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new Exception(e);
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
