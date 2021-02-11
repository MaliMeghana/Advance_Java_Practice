<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<script src="bootstrap/js/bootstrap.bundle.js"></script>

</head>
<body>
<br/>
	<div class="container" style="border:2px solid black">
	<div class="row">
	<div class="col-md-5 mt-4 ">
	<h2 style="color:blue">Register</h2>
	<hr/>
			<form class="form" action="user-create" method="post">
				<label>Name :</label> 
			   <input type="hidden" name="id" value="${user.id}" /> 
			   <input type="text" name="username" value="${user.username}" class="form-control" /> 
			   <label>Password :</label> 
			   <input type="password" name="password" value="${user.password}" class="form-control" /> 
			   <label>Email :</label> 
			   <input type="text" name="email" value="${user.email}" class="form-control" />
			   <label>Mobile :</label>
			   <input type="number" name="mobile" value="${user.mobile}" class="form-control" /><br>
			   <div class="form-group">
			   <c:if test="${user.id==null}">
			   <input type="submit" value="Add +" class="btn btn-success form-control" style="width:40%"/>
			   </c:if>
			   <c:if test="${user.id!=null}">
			   <input  value="Update" type="submit" formaction="user-update" class="btn btn-info form-control" style="width:40%;float:right"/>
			   </c:if>
			  <br/>
			   </div>
			</form>
		</div>
		<div  class="col-md-7 mt-4"> 
		<h2 style="color:green">User Info</h2>
		<hr/>
			<table class="table" style="text-align:center">
				<tr>
				    <th>ID</th>
					<th>USERNAME</th>
					<th>EMAIL</th>
					<th>MOBILE</th>
					<th colspan="2">ACTION</th>
				</tr>
				<c:forEach var="item" items="${userlist}">
					<tr>
					    <td>${item.id}</td>
						<td>${item.username}</td>
						<td>${item.email}</td>
						<td>${item.mobile}</td>
						<td><a href="user-delete?id=${item.id}"><button class="btn btn-danger">Delete</button></a></td>
						<td><a href="user-read1?id=${item.id}"><button class="btn btn-info">Update</button></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<br/>
	</div>

</body>
</html>