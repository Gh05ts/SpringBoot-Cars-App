<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
  <link rel="stylesheet" type="text/css" href="styles1.css">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Home</title>
  </head>

  <body>
  	<div data-select="${it.brand}" id="empDiv"></div>
    <div class="row">
      <div class="card">
        <form action="/interim" method="POST">
        <div class="card-header text-center">
          <h2>Best Choice Cars</h2>
        </div>
        <div class="card-body" style="overflow-y: auto; max-height: 61vh">
          <table class="table table-hover w-100">
            <thead>
              <tr>
                <th></th>
                <th>Brand</th>
                <th>Model</th>
                <th>Year</th>
                <th>Kms Driven</th>
                <th>Price</th>
                <th>Fuel</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="car" items="${it.cars}">
	            <tr>
	              <td>
	              	<div style="margin-top: 5px;" class="radio align-items-center justify-content-center">
	              	  <input type="radio" id="${car.id}" name="id" value="${car.id}">
	              	</div>
	              </td>
	              <td>${car.brand}</td>
	              <td>${car.model}</td>
	              <td>${car.year}</td>
	              <td>${car.kms}</td>
	              <td>${car.price}</td>
	              <td>${car.fuel}</td>	            
	            </tr>
              </c:forEach>              
            </tbody>
          </table>
        </div>
        <div class="card-footer align-items-center d-flex justify-content-center">
          <a href="/" id="dynamic">
            <button class="btn btn-secondary" type="button">Back</button>
          </a>
          <button class="btn btn-primary" type="submit" style="margin-right: 24px; margin-left: 24px;">
            Book Car
          </button>
          <a href="/">
            <button class="btn btn-danger" type="button">Home</button>
          </a>
        </div>
        
      </form>
      </div>
    </div>
  </body>
  <script>
    let el = document.getElementById("empDiv")
    let val = el.dataset.select
    let e = document.getElementById("dynamic")
    if(val === "true") {
      e.href = "/brandForm"
    } else {
      e.href = "/priceForm"
    }
  </script>
</html>