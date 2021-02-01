  
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
   
<%
	// ...after lot of computation
	List<String> list = Arrays.asList("A", "B", "C", "D");
	request.setAttribute("list", list);
%>    
    
    
<jsp:forward page="3-2.jsp"></jsp:forward>