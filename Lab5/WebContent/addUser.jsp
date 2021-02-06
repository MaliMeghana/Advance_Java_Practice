<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.Scanner"%>
<%

final String DB_URL="jdbc:mysql://localhost:3306/advance_java";
final String DB_DRIVER="com.mysql.cj.jdbc.Driver";
final String DB_USERNAME="root";
final String DB_PASSWORD="Mehar007*";
Connection con=null;
Statement ps=null;
PreparedStatement pss=null;
ResultSet rs=null;
Class.forName(DB_DRIVER);

//Connection Open
con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
System.out.println("DB Connected");
  
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<script src="bootstrap/js/bootstrap.bundle.js"></script>
</head>
<body>

	<div class="container-fluid">
	<div class="row">
	<div class="col-md-6 mr-4">
		<%
			ps=con.createStatement();
			String u=request.getParameter("u");
			int num=Integer.parseInt(u);
			String data="SELECT * FROM USER_REG WHERE ID='"+num+"'";
			rs=ps.executeQuery(data);
			while(rs.next()){
		%>

		<div class="col-md-6 mt-4">
			<h3 class="text-primary">Update User</h3>
			<form class="form" action="" method="post">
				<input type="hidden" name="id" value='<%=rs.getInt("ID")%>' /> 
				<label>Username:</label>
			    <input type="text" class="form-control" name="u_name"	value='<%=rs.getString("USERNAME")%>' /> 
			    <label>Password :</label>
				<input type="password" class="form-control"	name="u_pwd" value='<%=rs.getString("PASSWORD")%>' /> 
				<label>Email :</label> 
				<input type="email" class="form-control" name="u_email"	value='<%=rs.getString("EMAIL")%>' /> 
				<label>Mobile Number :</label> 
				<input type="number" class="form-control" name="u_mobile"
					value='<% =rs.getString("MOBILE")%>' />

				<button type="submit" class="btn btn-success mt-4">Update</button>
			</form>
		</div>
		<%} 
		String u_name=request.getParameter("u_name");
		String u_pwd=request.getParameter("u_pwd");
		String u_email=request.getParameter("u_email");
		String u_mobile=request.getParameter("u_mobile");
		String u_id=request.getParameter("id");
		String update="UPDATE USER_REG SET USERNAME=?, PASSWORD=?, EMAIL=?, MOBILE=? WHERE ID='"+u_id+"'";
		pss=con.prepareStatement(update);
		pss.setString(1,u_name);
		pss.setString(2,u_pwd);
		pss.setString(3,u_email);
		pss.setString(4,u_mobile);
	
		pss.executeUpdate();
		%>
	</div>
	<%
	String select ="SELECT * FROM USER_REG";
	pss = con.prepareStatement(select);
	rs = pss.executeQuery();
	%>
	<div class="col-md-6 mt-4">
   <h2>Users</h2>
		<table class="table">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Mobile</th>
			</tr>
			<%
			while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getInt("ID")%></td>
				<td><%=rs.getString("USERNAME")%></td>
				<td><%=rs.getString("EMAIL")%></td>
				<td><%=rs.getString("MOBILE")%></td>
			</tr>
			<%
			}
			rs.close();
			%>
		</table>
	</div>
	</div>
	</div>
	<%con.close(); %>
</body>
</html>