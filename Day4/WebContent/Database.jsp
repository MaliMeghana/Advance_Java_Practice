
   <%@page import="java.sql.*" %>
<%
	
	  String DB_DRIVER="com.mysql.cj.jdbc.Driver";
	  String DB_URL="jdbc:mysql://localhost:3306/advance_java";
	  String DB_USERNAME="root";
	  String DB_PASSWORD="Mehar007*";
	  
	  Class.forName(DB_DRIVER);
	  Connection con=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
	  String name=request.getParameter("name_Id");
	  String std=request.getParameter("std_Id");
	  String add=request.getParameter("add_Id");
	  
	  String insert="INSERT INTO STUDENT (NAME,STD,ADDRESS)VALUES('"+name+","+std+","+add+"')";
	  String select="SELECT * FROM STUDENT";
	  
	
	  
	  Statement st=con.createStatement();
	  int i=st.executeUpdate(insert);
	  
	  PreparedStatement ps=con.prepareStatement(select);
	  ResultSet rs=ps.executeQuery();
	
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

<table class="table">
<tr>
<th>Id</th>
<th>Name</th>
<th>Stdandard</th>
<th>Address</th>
</tr>
<tr>
<td><%=rs.getString(0) %></td>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>
</tr>
</table>

</body>

<%con.close(); %>
</html>