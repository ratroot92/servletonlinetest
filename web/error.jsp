<%-- 
    Document   : error
    Created on : May 26, 2019, 10:06:22 PM
    Author     : asd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="bootstrap.css">
    </head>
    <body class="container-fluid bg-warning text-center">
        <h1>JSP ERROR PAGE </h1>
        <%= exception%>
    </body>
</html>


<div class="jumbotron">
    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">USER ID</th>
      <th scope="col">USER NAME</th>
      <th scope="col">USER PASSWORD</th>
      <th scope="col">USER TYPE</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>the Bird</td>
      <td>@twitter</td>
    </tr>
  </tbody>
</table>
        </div>
    </div>
</div>