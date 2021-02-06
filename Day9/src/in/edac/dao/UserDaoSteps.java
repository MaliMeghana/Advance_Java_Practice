package in.edac.dao;
/*
 * CRUD Queries
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserDaoSteps {

	public static final String DB_URL = "jdbc:mysql://localhost:3306/advance_java";
	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_USER = "root";
	public static final String DB_PASSWORD = "Mehar007*";
	Connection con = null;

	public void checkConnectionOld() throws Exception {
		try {
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			System.out.println("Success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

	// With resource
	public void checkConnectionRes() {
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);) {
			Class.forName(DB_DRIVER);
			System.out.println("Success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public boolean createUserVer1(String username, String password, String email, int mobile) {
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			Class.forName(DB_DRIVER);

			// Insert Add unique values(setting constraints)
			String sql = "INSERT INTO user_reg (USERNAME,PASSWORD,EMAIL,MOBILE) VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setInt(4, mobile);

			ps.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean createUserVer2(User user) {
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			Class.forName(DB_DRIVER);

			// Insert Add unique values(setting constraints)
			String sql = "INSERT INTO user_reg (USERNAME,PASSWORD,EMAIL,MOBILE) VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setInt(4, user.getMobile());

			ps.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		UserDaoSteps dao = new UserDaoSteps();
		// dao.checkConnectionRes();
		// dao.createUserVer1("Harshal","har@gmail.com","34",3434);
		User user = new User("Tanuja", "123", "f@gmail", 233);

		dao.createUserVer2(user);
	}
}
