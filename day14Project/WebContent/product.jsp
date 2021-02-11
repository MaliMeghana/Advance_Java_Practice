<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="common-header.jsp"%>

<%

//checking login
if(session.getAttribute("auth")==null){
	response.sendRedirect("/day14Project/login.jsp");
	return;
}
%>

Product
</body>
</html>