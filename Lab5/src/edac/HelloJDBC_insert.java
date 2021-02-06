package edac;

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
		
		//Dynamic Loading !! the Class Driver
		//java.lang
		Class.forName(DB_DRIVER);
		
		//Connection Open
		con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
		System.out.println("DB Connected");
		
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
}
}
