<jsp:include page="common-header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid">

	<div class="col-md-6 offset-md-3 mt-4">

		<nav>
			<div class="nav nav-tabs" id="nav-tab" role="tablist">
				<a class="nav-link active" id="nav-home-tab" data-bs-toggle="tab"
					href="#nav-home" role="tab" aria-controls="nav-home"
					aria-selected="true">Category</a> <a class="nav-link"
					id="nav-profile-tab" data-bs-toggle="tab" href="#nav-profile"
					role="tab" aria-controls="nav-profile" aria-selected="false">Add
					Category</a>
			</div>
		</nav>
		<div class="tab-content" id="nav-tabContent">
			<div class="tab-pane fade show active" id="nav-home" role="tabpanel"
				aria-labelledby="nav-home-tab">

				<table class="table">
					<tr>
						<th>Category</th>
						<th>Action</th>
					</tr>
					<c:forEach var="item" items="${category}">
						<tr>
							<td>${item.category}</td>
							<td><a href="category-delete-action?id=${item.id}"><button
										class="btn-sm btn-danger">Delete</button></a> <a
								href="category-one-action?id=${item.id}"><button
										class="btn-sm btn-info">Update</button></a></td>
						</tr>
					</c:forEach>

				</table>

			</div>
			<div class="tab-pane fade" id="nav-profile" role="tabpanel"
				aria-labelledby="nav-profile-tab">

				<form action="category-add-action" method="post">
					<label>Category Name : </label>
					
					<c:if test="${categoryone==null }">
						<input type="text" name="category" class="form-control" />
						<br />
						<input  value="Add +" type="submit"  class="btn btn-info form-control" style="width:40%;float:left"/>
					</c:if>
					<c:if test="${categoryone!=null }">
						<c:forEach var="item" items="${categoryone}">
							<input type="text" name="category" value="${item.category}" class="form-control" />
							   <br />
							<input  value="Update" type="submit" formaction="category-update-action?id=${item.id}" class="btn btn-info form-control" style="width:40%;float:right"/>
						</c:forEach>
					</c:if>
					
				</form>

			</div>
		</div>
	</div>

</div>


</body>
</html>