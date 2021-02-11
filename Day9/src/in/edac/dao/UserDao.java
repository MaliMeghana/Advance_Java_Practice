package in.edac.dao;

/*
 * CRUD Queries
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

	public static final String DB_URL = "jdbc:mysql://localhost:3306/advance_java";
	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_USER = "root";
	public static final String DB_PASSWORD = "Mehar007*";
	Connection con = null;
	

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

	//Create User
	public boolean createUser(User user) throws Exception{
		Class.forName(DB_DRIVER);
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			

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
			throw e;
		}
	}

	public  boolean updateUser(User user)throws Exception {
		Class.forName(DB_DRIVER);
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			

			//update particular value
			String sql = "UPDATE user_reg SET USERNAME=?, PASSWORD=?, EMAIL=?, MOBILE=? WHERE ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setInt(4, user.getMobile());
			ps.setInt(5, user.getId());
			
			ps.executeUpdate();
		return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteUser(User user) throws Exception {
		Class.forName(DB_DRIVER);
		try (Connection con=DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
			String sql="DELETE FROM user_reg WHERE ID=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, user.getId());
			
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	public List<User> readAllUser() throws Exception {
		Class.forName(DB_DRIVER);
		try (Connection con=DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
			String sql="SELECT * FROM user_reg";
			
			PreparedStatement ps=con.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			
			List<User> userlist=new ArrayList<User>();
			
			while(rs.next()) {
				int colId=rs.getInt("ID");
				String colUsername=rs.getString("USERNAME");
				String colEmail=rs.getString("EMAIL");
				int colMobile=rs.getInt("MOBILE");
			
				User user=new User();
				user.setId(colId);
				user.setUsername(colUsername);
				user.setEmail(colEmail);
				user.setMobile(colMobile);
				
				userlist.add(user);
			}
			
			return userlist;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}
	
	public User readUser(User user) throws Exception {
		Class.forName(DB_DRIVER);
		try (Connection con=DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
			String sql="SELECT * FROM user_reg WHERE ID=?";
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,user.getId());
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				user.setId(rs.getInt("ID"));
				user.setUsername(rs.getString("USERNAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setEmail(rs.getString("EMAIL"));
				user.setMobile(rs.getInt("MOBILE"));
				//list.add(user);
			}
			return user;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void main(String[] args) throws Exception{
//		UserDao dao = new UserDao();
	
//		User user = new User("Tanuja", "123", "f@gmail", 233);
//		dao.createUser(user);
		
//		User user=new User("Tanuja", "123", "f@gmail", 233);
//		user.setId(3);
//		dao.updateUser(user);
//		
//		User user=new User();
//		user.setId(4);
//		dao.deleteUser(user);
	}
}


/*
Diff Between  forward and redirect
in forward we can reuse
url is not visible in forward
same request get service
same request continue
advantage with redirect ==>url change (same as disadvantage)

*/