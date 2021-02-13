
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common-css-js.jsp"%>


<body>


	<div class="container-fluid" >

		<div class="row " style="height: 100vh">

			<div class="col-6  d-flex flex-column justify-content-center align-items-center" style="font-family:cursive">
					<div class="row" style="font-size: 1.8rem;color:darkblue;text-align:center">
			<div class="col-9 offset-2 py-2 px-4 rounded" >
				        Oriflame Online Shopping
				</div>
			</div>	
				<div class="row">
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
			    <div class="col-10 offset-1 mt-3">
			 
				   <form action="register-action" method="post">
				   <div>
				  <c:if test="${param.q==1}">
					  <div class="alert alert-success" role="alert">
						  Registration Succesfully....
					  </div>
				  </c:if>
				    <c:if test="${param.q==0}">
					  <div class="alert alert-danger" role="alert">
						 Registration Error !!!
					  </div>
				  </c:if>
				    </div>
				    <div class="bg-dark text-light px-4 py-2 rounded d-flex justify-content-center" style="font-family:cursive;font-size:1.75rem">Registration</div>
				    <div class="mt-1">
				       <input type="text" name="fname"class="form-control form-control"  placeholder="First Name..."/>
				    </div>
				      <div class="mt-1">
				       <input type="text" name="lname" class="form-control form-control" placeholder="Last Name..."/>
				    </div>
				      <div class="mt-1">
				       <input type="text" name="email" class="form-control form-control" placeholder="Email..."/>
				    </div>
				      <div class="mt-1">
				       <input type="text" name="mobile" class="form-control form-control" placeholder="Mobile..."/>
				    </div>
				       <div class="mt-1">
				       <input type="password" name="password" class="form-control form-control" placeholder="Password..."/>
				    </div>
				       <div class="mt-1">
				       <input type="text" name="state" class="form-control form-control" placeholder="State..."/>
				    </div>
				       <div class="mt-1">
				       <input type="text" name="pincode" class="form-control form-control" placeholder="Pincode..."/>
				    </div>
				       <div class="mt-1">
				       <input type="text" name="city" class="form-control form-control" placeholder="City..."/>
				    </div>
				      <div class="mt-1">
				       <input type="submit" class="btn btn-primary btn-block form-control" value="Register"/>
				    </div>
				      <div class="mt-1">
				       <input type="reset" class="btn btn-secondary btn-block form-control" value="Cancle"/>
				    </div>
				     <div class="mt-1">
				      <a href="login.jsp" class="btn btn-link">Login In Here...</a>
				    </div>
				</form>
		   	   </div>
			 </div>
			</div>
		</div>

	</div>


</body>
</html>