<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Or Update</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
		<center>${form }</center>
		<form method="post" action="${getUrl }">
		<input type="hidden" name="productId" value="${data.productId }"/>
			<div class="mb-3">
				<label for="exampleInputusername1" class="form-label">Product Name
				</label>
				 <input type="text" class="form-control" id="exampleInputusername1"
					name="productName" value="${data.productName }">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Product Price</label>
				<input type="text" class="form-control"
					id="exampleInputPassword1" name="productPrice" value="${data.productPrice }">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>

	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>