package in.suryaumapathy.projects.collage_admission.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() {

		Connection conn = null;
		String url = "jdbc:mysql://localhost/collage_admission";
		String user = "root";
		String password = "Root@123";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			// Create a Connection to the Database
			conn = DriverManager.getConnection(url, user, password);

//			System.out.println("Successfully connected to database");

		} catch (Exception e) {

			e.printStackTrace();
			throw new RuntimeException(e);

		}

		return conn;

	}

	public static void close(Connection conn, PreparedStatement ps) {

		try {
			if (ps != null) {
				ps.close();
			}

			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			
			if(rs != null) {
				rs.close();
			}
			
			
			if (ps != null) {
				ps.close();
			}

			if (conn != null) {
				conn.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

}
