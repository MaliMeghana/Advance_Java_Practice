<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common-header.jsp"%>
<%

//checking login
if(session.getAttribute("auth")==null){
	response.sendRedirect("/miniproject/login.jsp");
	return;
}
%>

<div class="row mt-2">
 <img src="img/home.jpg" style="height:100%;width:100%;object-fit:cover" class="card-img-top" alt="...">
</div>

</body>
</html>