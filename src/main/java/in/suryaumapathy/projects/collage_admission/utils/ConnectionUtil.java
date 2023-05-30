package in.suryaumapathy.projects.collage_admission.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	public static Connection getConnection() {

		Connection conn = null;
		String url = null; // "jdbc:mysql://localhost/collage_admission";
		String user = null; // "root";
		String password = null; // "Root@123";

		try {
			
			Properties props = new Properties();
			InputStream input = ConnectionUtil.class.getClassLoader().getResourceAsStream("application.properties");
			props.load(input);
			
			url = props.getProperty("db.url");
			user = props.getProperty("db.user");
			password = props.getProperty("db.password");
			
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

			if (rs != null) {
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
