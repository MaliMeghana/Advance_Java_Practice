<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.sql.*"%>
<%
		String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost:3306/advance_java";
		String DB_USERNAME = "root";
		String DB_PASSWORD = "Mehar007*";
		PreparedStatement ps = null;
		//Connection
		Class.forName(DB_DRIVER);
		Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		//insert
		String name = request.getParameter("name_Id");
		String pwd = request.getParameter("pwd_Id");
		String email = request.getParameter("email_Id");		
		String mobile= request.getParameter("mobile_Id");
		String insert = "INSERT INTO USER_REG (USERNAME, PASSWORD, EMAIL, MOBILE) values(?,?,?,?)";
		String select = "SELECT * FROM USER_REG";
	
		int updateQuery = 0;
		ps = con.prepareStatement(insert);
		
		ps.setString(1, name);
		ps.setString(2, pwd);
		ps.setString(3, email);
		ps.setString(4, mobile);
		updateQuery = ps.executeUpdate();

//select
ps = con.prepareStatement(select);
ResultSet rs = ps.executeQuery();
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

	<div class="container-fluid d-flex justify-content-center">
		<div class="col-md-4 offset-col-4 mt-4">

			<form method="post">

				    <label>Name :</label> 
				    <input type="text" class="form-control"	name="name_Id" /> 
					<label>Password :</label>
				    <input type="password"	class="form-control" name="pwd_Id" /> 
					<label>Email :</label> 
					<input type="email" class="form-control" name="email_Id" />
					<label>Mobile Number :</label> 
					<input type="number" class="form-control" name="mobile_Id" />
					<br />
				<button class="btn btn-success" type="submit" value="submit">Add
					Student</button>

			</form>
		</div>
	</div>
	<div>
		<%
		if (updateQuery != 0) {
		%>
		<table class="table">
			<tr>
				<th>Data Inserted Successfully</th>
			</tr>
		</table>

	</div>
	<%
	}
	%>
	<div>

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
	<%ps.close();
con.close();
%>
</body>
</html>