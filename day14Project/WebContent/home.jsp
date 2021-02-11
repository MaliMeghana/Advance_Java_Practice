<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common-header.jsp"%>
<%

//checking login
if(session.getAttribute("auth")==null){
	response.sendRedirect("/day14Project/login.jsp");
	return;
}
%>

<div class="row">
<c:forEach begin="0" end="20" varStatus="myIndex">
   <div class="col-3">
      <div class="card" style="width: 18rem;">
		  <img src="https://picsum.photos/200/300" style="height:200px;object-fit:cover" class="card-img-top" alt="...">
		  <div class="card-body">
		    <h5 class="card-title">Card title</h5>
		    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
		    <a href="#" class="btn btn-primary">Go somewhere</a>
		  </div>
	 </div>
   </div>
</c:forEach>
</div>


</body>
</html>