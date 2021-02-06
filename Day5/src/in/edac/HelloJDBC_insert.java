package in.edac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


/*
 * 
 * Create schema using java
 * CRUD create,insert,update,delete
 */



public class HelloJDBC_insert {
	
	
	public static final String DB_URL="jdbc:mysql://localhost:3306/advance_java";
	public static final String DB_DRIVER="com.mysql.cj.jdbc.Driver";
	public static final String DB_USERNAME="root";
	public static final String DB_PASSWORD="Mehar007*";
	
   public static void main(String[] args) {
	   Connection con=null;
	try
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("ENter Username");
		String u_name=sc.nextLine();
		System.out.println("ENter Password");
		String u_pwd=sc.nextLine();
		System.out.println("ENter Email");
		String u_email=sc.nextLine();
		System.out.println("ENter MobileNo");
		String u_mobile=sc.nextLine();
		
		//Dynamic Loading !! the Class Driver
		//java.lang
		Class.forName(DB_DRIVER);
		
		//Connection Open
		con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
		System.out.println("DB Connected");
		
		//Query		
		String sql_insert="INSERT INTO USER_REG(USERNAME,PASSWORD,EMAIL,MOBILE) VALUES('"+u_name+"','"+u_pwd+"','"+u_email+"','"+u_mobile+"')";
		//Convert to sql statement
		PreparedStatement ps=con.prepareStatement(sql_insert);
		ps.executeUpdate(); //returns boolean value
		
		System.out.println("Inserted");
		sc.close();
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
