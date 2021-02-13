<jsp:include page="common-header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<div class="container-fluid">

		<div class="col-md-6 offset-md-3 mt-4">

			<nav>
			  <div class="nav nav-tabs" id="nav-tab" role="tablist">
			    <a class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Products</a>
			    <a class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">Add Products</a>
             </div>
          </nav>
			<div class="tab-content" id="nav-tabContent">
			  <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
			  <table class="table">
				  <tr>
					  <th>Product</th>
					  <th>Price</th>
					 
				  </tr>
				  <c:forEach var="item" items="${product}">
				    <tr>
					  <td>${item.pname}</td>
					  <td>${item.price}</td>
					  
				  </tr>
				  </c:forEach>
			  </table>
			  
			  </div>
			  <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
			  
			  <form action="product-add-action">
			     <label>Product Name :</label>
			     <input type="text" name="pname" class="form-control" />
			     <label>Product Price :</label>
			     <input type="text" name="price" class="form-control" />
			     <label>Product Image :</label>
			     <input type="file" name="image" class="form-control" />
			     <label>Product Category :</label>
			     <select class="form-control" name="cid">
			     <c:forEach var="item" items="${category}" >
			         <option value="${item.id}">${item.category}</option>
			      </c:forEach>
			     </select>
			     <br/>
			         <input type="submit" class="form-control" />
			  </form>
			  
			  </div>
			</div>
		</div>

	</div>


</body>
</html>