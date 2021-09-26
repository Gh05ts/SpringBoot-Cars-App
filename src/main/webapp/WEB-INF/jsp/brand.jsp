<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
	<link rel="stylesheet" type="text/css" href="styles.css">
<meta charset="UTF-8">
<title>Brand Condition</title>
</head>
<body>
	<div class="row">
		<div class="card card-block d-flex overflow-auto">
			<div class="card-header text-center">
				<h2>Best Choice Cars</h2>
				<br>
				<h5>Choose brand to find available models</h5>
			</div>
			<div class="card-body align-items-center d-flex justify-content-center">
				<form method="POST" action="/showBrand">
					<div class="form-group">
						<label for="formBrand">Select Brand: </label>
						<select class="form-control" name="formBrand" id="formBrand">
							<c:forEach var="brand" items="${it.list}">
								<option>${brand}</option>
							</c:forEach>
						</select>
					</div>
					<br>
					<a href="/" style="margin-right: 12px;">
						<button type="button" class="btn btn-large btn-secondary">Back</button>
					</a>
					<button class="btn btn-large btn-primary" style="margin-left: 12px;" type="submit">Find Models</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>