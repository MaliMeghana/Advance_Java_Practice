<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	// Consume the task done by 3-1 and 3-2
	String city = (String)request.getAttribute("city");
	int id = (Integer)request.getAttribute("id");
	
	List<String> list= (List<String>)request.getAttribute("list");
%>   
  
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Forward Demo :: using request</h1>
<div><%=city %> <%=id %></div>

<%
	for(int i=0; i<list.size(); i++) {
%>		
		<div style="color:green; font-family: cursive">
			<%= list.get(i) %>
		</div>
<% 	}
%>

</body>
</html>