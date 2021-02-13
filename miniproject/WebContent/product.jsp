<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="common-header.jsp"%>

<%

//checking login
if(session.getAttribute("auth")==null){
	response.sendRedirect("/miniproject/login.jsp");
	return;
}
%>
<div class="container-fluid">
	<div class="row bg-light text-dark justify-content-center mt-2"
		style="height: 9vh; font-family: cursive">
        
		<c:forEach var="item" items="${category}">
			<div class="col-2 d-flex justify-content-center align-items-center">
				<a href="product-one-action?cid=${item.id}" type="submit" class="btn btn-outline-info">${item.category}</a>
			</div>
		</c:forEach>
		
	</div>
	
	<div class="row">
       <img src="img/Makeup.jpg" style="height:100%;width:100%;object-fit:cover" class="card-img-top" alt="...">
	</div>

	<div class="row mt-3">

	  <c:forEach var="item" items="${productbycat}">
   <div class="col-3">
      <div class="card" style="width: 18rem;">
		  <img src="${item.path }" style="height:80%;" class="card-img-top" alt="...">
		  <div class="card-body">
		    <h5 class="card-title">${item.pname }</h5>
		    <p class="card-text"></p>
		    <a href="#" class="btn btn-primary">Add to Cart</a>
		  </div>
	 </div>
   </div>
</c:forEach>

	</div>

</div>
</body>
</html>