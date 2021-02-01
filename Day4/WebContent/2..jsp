<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.Arrays"%>
  <%@page import="java.util.List"%>   
  <jsp:include page="2-1.jsp"></jsp:include>
    <%
       
        
        List<String> list = Arrays.asList("A", "B", "C", "D");
    	request.setAttribute("list", list);
    	
    	// get 
    	List<String> list1 = (List<String>) request.getAttribute("list");
    
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Using Expression Language.
<div>${requestScope.city} ${requestScope.id}</div>


<%
  for(int i=0; i<list1.size();i++)
  {
%>
      <div style="color:green; font-family;cursive">
	  <%=list1.get(i) %>
	  </div>
<%  }

%>
</body>
</html>