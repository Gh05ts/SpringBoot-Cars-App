<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
  <link rel="stylesheet" type="text/css" href="styles.css">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Home</title>
  </head>

  <body>
    <div class="row">
      <div class="card card-block d-flex overflow-auto">
        <div class="card-header text-center">
          <h2>Best Choice Cars</h2>
        </div>
        <div class="card-body align-items-center d-flex justify-content-center">
          <a style="margin-right: 12px;" href="/brandForm">
            <button class="btn btn-large btn-primary">Search Cars By Brand</button>
          </a>
          <a style="margin-left: 12px;" href="/priceForm">
            <button class="btn btn-large btn-primary">Search Cars By Price</button>
          </a>
        </div>
      </div>
    </div>
  </body>
</html>