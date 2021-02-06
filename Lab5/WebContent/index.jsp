<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%
	   String u="1";
	   request.setAttribute("u", 1);
	
	
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
	<h1>CRUD Example</h1>
	<a href="addUser.jsp">Update USER</a>
	<a href="">View Users</a>
</body>
</html>