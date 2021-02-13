
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common-css-js.jsp"%>

<body>


	<div class="container-fluid">

		<div class="row" style="height: 100vh">

			<div class="col-6 d-flex flex-column justify-content-center align-items-center" style="font-family:cursive">
			<div class="row" style="font-size: 1.8rem;color:darkblue;text-align:center">
			<div class="col-9 offset-2 py-2 px-4 rounded" >
				        Oriflame Online Shopping
				</div>
			</div>	
				<div class="row mt-2">
					<div class="col-9 offset-2" style="text-align: center">
						Themes are built on Bootstrap as their own extended frameworks,
						rich with new components and plugins, documentation, and powerful
						build tools. Themes are built on Bootstrap as their own extended
						frameworks, rich with new components and plugins, documentation,
						and powerful build tools. Themes are built on Bootstrap as their
						own extended frameworks, rich with new components and plugins,
						documentation, and powerful build tools. Themes are built on
						Bootstrap as their own extended frameworks, rich with new
						components and plugins, documentation, and powerful build tools.</div>
				</div>
			</div>

			<div class="col-6 text-light d-flex flex-column justify-content-center align-items-center">
			  <div class="row" style="width:80%">
			    <div class="col-10 offset-1">
			 
				   <form action="login-action" method="post">
				   <div>
				  <c:if test="${param.q==1}">
					  <div class="alert alert-success" role="alert">
						  Login Succesfully....
					  </div>
				  </c:if>
				    <c:if test="${param.q==0}">
					  <div class="alert alert-danger" role="alert">
						 Invalid user !!!
					  </div>
				  </c:if>
				    </div>
				    <div class="bg-light text-dark px-4 py-2 rounded d-flex justify-content-center" style="font-family:cursive;font-size:1.75rem">Login</div>
				    <div class="mt-1">
				       <input type="text" class="form-control form-control-lg" name="email"  placeholder="Email"/>
				    </div>
				      <div class="mt-1">
				       <input type="password" class="form-control form-control-lg" name="password" placeholder="Password..."/>
				    </div>
				      <div class="mt-1">
				       <input type="submit" class="btn btn-primary btn-block form-control" value="Login"/>
				    </div>
				      <div class="mt-1">
				       <input type="reset" class="btn btn-secondary btn-block form-control" value="Cancle"/>
				    </div>
				     <div class="mt-1">
				      <a href="register.jsp" class="btn btn-link">Register Here...</a>
				    </div>
				</form>
		   	   </div>
			 </div>
			</div>
		</div>

	</div>


</body>
</html>