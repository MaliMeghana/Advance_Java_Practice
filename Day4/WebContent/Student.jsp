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
		String std = request.getParameter("std_Id");
		String add = request.getParameter("add_Id");		
		String insert = "INSERT INTO STUDENT (NAME,STD,ADDRESS)values(?,?,?)";
		String select = "SELECT * FROM STUDENT";
	
		int updateQuery = 0;
		ps = con.prepareStatement(insert);
		
		ps.setString(1, name);
		ps.setString(2, std);
		ps.setString(3, add);
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

				<label>Name :</label> <input type="text" class="form-control"
					name="name_Id" /> <label>Std :</label> <input type="text"
					class="form-control" name="std_Id" /> <label>Add :</label> <input
					type="text" class="form-control" name="add_Id" /><br />
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
				<th>Standard</th>
				<th>Address</th>
			</tr>
			<%
			while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getInt("id")%></td>
				<td><%=rs.getString("Name")%></td>
				<td><%=rs.getString("Std")%></td>
				<td><%=rs.getString("Address")%></td>
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