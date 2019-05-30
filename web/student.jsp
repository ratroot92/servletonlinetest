<%-- 
    Document   : test.jsp
    Created on : May 27, 2019, 5:50:28 AM
    Author     : asd
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="connection.connection"%>
<%@page import="java.sql.ResultSet"%>

<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp" %>
<!DOCTYPE html>
<%! 
String studentname;
String studentpassword;

%>
<%
 studentname=(String) session.getAttribute("studentname");
 studentpassword=(String) session.getAttribute("studentpassword");
if(studentname.equals("") || studentname.equals("")){
          response.sendRedirect("login.jsp");

                                                        }

%>

<html>
  <head>
    <title>Student Panel</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="bootstrap.css">
  </head>
  <body>
    <div class="jumbotron-fluid bg-light text-center">
      <h1 class="display-4">STUDENT PANEL </h1>
       <button type="button" class="btn btn-danger">Login Details</button>
        <button type="button" class="btn btn-primary">Student Name :<%="  "+studentname%></button>
         <button type="button" class="btn btn-primary">Student Name :<%="  "+studentpassword%></button>
          <a href="index.html" class="btn btn-warning">Sign Out</a>
    </div>
    <div class="container-fluid">
      <ul class="nav nav-tabs">
        <li class="active "><a href="#a" class="nav-link" datatoggle="tab"  >GIVE TEST</a></li>
        <li class=""><a href="#b" class="nav-link" datatoggle="tab"  >RESULTS</a></li>
        <li class=""><a href="#c" class="nav-link" datatoggle="tab"  >TEST</a></li>
      </ul>
      <div class="tab-content">
        <!-- star of admin tab-->
        <div class="tab-pane active"  id="a">
        <a href="test.jsp" class=" btn btn-block btn-danger mt-4">START TEST </a>
        </div>
        <!-- end  of admin tab-->
        <div class="tab-pane text-danger"  id="b">adasdasdasdasdasd</div>
        <div class="tab-pane text-danger"  id="c">categasdasdasdasorytab</div>
      </div>
    </div>
    <!-- admin form-->
   
    <!-- admin form-->
    
    <!-- question form-->
   
    <!-- admin form-->
    <footer>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
      <!-- Minified JavaScript -->
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </footer>
  </body>
</html>