package in.edac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/*
 * 
 * Create schema using java
 * CRUD create,insert,update,delete
 * 
 * 
 * Recommended Select methods
 */

public class HelloJDBC_select {

	public static final String DB_URL = "jdbc:mysql://localhost:3306/advance_java";
	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "Mehar007*";

	public static void main(String[] args) throws Exception {
		Connection con = null;
		try {

			// Dynamic Loading !! the Class Driver
			// java.lang
			Class.forName(DB_DRIVER);

			// Connection Open
			con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			System.out.println("DB Connected");

			// Query
			String sql_select = "SELECT * FROM USER_REG";

			// Convert to sql statement
			PreparedStatement ps = con.prepareStatement(sql_select);
			ResultSet rs = ps.executeQuery(); // return set of records

			System.out.println("Table Values");
			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("USERNAME");
				String mobile = rs.getString("MOBILE");

				System.out.println(id + " " + name + " " + mobile);
			}

			System.out.println("Selected");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// OR throw exception
			con.close();
		}
	}
}
