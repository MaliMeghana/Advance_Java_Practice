<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common-css-js.jsp"%>


<body>

	<div class="container-fluid">
	 <div class="row bg-dark text-light" style="height:9vh;font-family:cursive">
		  <div class="col-3 d-flex align-items-center text-light"> <a href="home.jsp" class="btn btn-warning">Oriflame </a>
	       </div>
	      
	       	<div class="col-9 d-flex justify-content-end align-items-center">
	          <c:if test="${user==1}">
	           <div>
	             <a href="aproduct.jsp" class="btn btn-secondary">Products</a>
	           </div>
	           <div class="ml-1">
	             <a href="category-all-action" class="btn btn-secondary">Category</a>
	           </div>
	          </c:if> 
	            <c:if test="${user==2}">
	           <div>
	             <a href="product.jsp" class="btn btn-secondary">Products</a>
	           </div>
	           <div class="ml-1">
	             <a href="service.jsp" class="btn btn-secondary">Service</a>
	           </div>
	          </c:if> 
	           <div class="ml-1">
	             <a href="logout-action" class="btn btn-secondary">Logout</a>
	           </div>
	       </div>
		</div>
		
		
	</div>
