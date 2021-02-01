<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.Connection" %>
     <%@page import="java.sql.ResultSet" %>
       <%@page import="java.sql.DriverManager" %>
        <%@page import="java.sql.PreparedStatement" %>


<%

     String DB_URL="jdbc:mysql://localhost:3306/practical";  
     String DB_DRIVER="com.mysql.cj.jdbc.Driver";
     String DB_USER="root";
     String DB_PASSWORD="Mehar007*";
     
     
     Class.forName(DB_DRIVER);
     Connection con=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
     
     String query="SELECT * FROM AUTHOR";
     
     PreparedStatement ps=con.prepareStatement(query);
     
     ResultSet rs=ps.executeQuery();
     

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
<tr>
<th>ID</th>
<th>Name</th>
</tr>
<tr>
<%
    while(rs.next())
    {
    	int author_id=rs.getInt("author_id");
    	String name=rs.getString("name");
  %>
<td><%= author_id%></td>
<td><%= name%></td>
<%} %>
</tr>
</table>
 
<% con.close(); %>
</body>
</html>

