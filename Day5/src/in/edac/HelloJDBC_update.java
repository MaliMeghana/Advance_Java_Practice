package in.edac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;




/*
 * 
 * Create schema using java
 * CRUD create,insert,update,delete
 * 
 * 
 * Recommended Update methods
 */



public class HelloJDBC_update {
	
	
	public static final String DB_URL="jdbc:mysql://localhost:3306/advance_java";
	public static final String DB_DRIVER="com.mysql.cj.jdbc.Driver";
	public static final String DB_USERNAME="root";
	public static final String DB_PASSWORD="Mehar007*";
	
   public static void main(String[] args) {
	   Connection con=null;
	try
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("ENter Updated Username");
		String u_name=sc.nextLine();
		System.out.println("Id for update");
		int u_id=sc.nextInt();
		
		//Dynamic Loading !! the Class Driver
		//java.lang
		Class.forName(DB_DRIVER);
		
		//Connection Open
		con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
		System.out.println("DB Connected");
		
		//Query		
		String sql_update="UPDATE USER_REG SET USERNAME=? WHERE ID=?";
		
		//Convert to sql statement
		PreparedStatement ps=con.prepareStatement(sql_update);
		ps.setNString(1, u_name);
		ps.setInt(2, u_id);
	
		ps.executeUpdate();
		
		System.out.println("Updated");
		
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	finally {
		//OR throw exception
		try{
			
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
}
