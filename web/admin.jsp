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

<html>
  <head>
    <title>Admin Panel</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="bootstrap.css">
  </head>
  <body>
    <%! 
String adminname;
String adminpassword;

%>
<%

 adminname=(String) session.getAttribute("adminname");
 adminpassword=(String) session.getAttribute("adminpassword");
if(adminname.equals("") || adminpassword.equals("")){
          response.sendRedirect("login.jsp");

                                                        }
    

%>
    <div class="jumbotron-fluid bg-light text-center">
      <h1 class="display-4">ADMIN PANEL </h1>
       <button type="button" class="btn btn-danger">Login Details</button>
        <button type="button" class="btn btn-primary">Admin Name :<%="  "+adminname%></button>
         <button type="button" class="btn btn-primary">Admin Name :<%="  "+adminpassword%></button>
          <a href="index.html" class="btn btn-warning">Sign Out</a>
    </div>
   
    <!-- admin form-->
    <div class="jumbotron bg-dark pb-3 mt-1">
      <div class="row">
        <div class="col-md-10 text-center ">
          <button type="button" class="btn btn-block bg-primary ml-5" style="width: 661px">ADD DELETE UPDATE ADMIN /STUDENT</button>
          
          <form class="form-group "  method="POST" action="add_admin">
            <div class="form-inline mt-4 ml-5 ">
              <label class="form-control " align="left" style="width: 200px;" for="username"> USER ID :</label>
              <input type="text" name="userid" placeholder="userid" class="form-control  ml-1" id="userid" style="width: 457px;" >
            </div>
            <div class="form-inline mt-2 ml-5">
              <label class="form-control" align="left" style="width: 200px;" for="username"> USER NAME :</label>
              <input type="text" name="username" placeholder="username" class="form-control  ml-1" id="username" style="width: 457px;" >
            </div>
            <div class="form-inline mt-2 ml-5">
              <label class="form-control" align="left" style="width: 200px;" for="password"> USER PASSWORD :</label>
              <input type="text" name="password" placeholder="password" class="form-control  ml-1" id="password" style="width: 457px;" >
              
            </div>
            <div class="form-inline mt-2 ml-5">
              <label class="form-control" for="type" align="left" style="width: 200px;" for="password"> USER TYPE :</label>
              <select class="form-control ml-1" name="type" id="type" style="width: 456px;">
                <option value="admin">Admin</option>
                <option value="student">Student</option>
              </select>
              
            </div>
            
            
            
          </div>
          <div class="col-md-2 d-flex flex-column text-light">
            <input type="submit" name="s1" value="insert" class="btn btn-warning  " style="height: 46px;">
            <input type="submit" name="s1" value="update" class="btn btn-warning mt-3"style="height: 46px;"  >
            <input type="submit" name="s1" value="delete" class="btn btn-warning  mt-3"style="height: 46px;"  >
            <input type="submit" name="s1" value="view" class="btn btn-warning mt-3" style="height: 46px;" >
             <input type="submit" name="s1" value="starttest" class="btn btn-warning mt-3" style="height: 46px;" >
            
          </div>
        </form>
      </div>
    </div>
    <!-- admin form-->
    
    <!-- question form-->
    <div class="jumbotron bg-dark pb-3">
      <div class="row">
        <div class="col-md-10 text-center ">
          <button type="button" class="btn btn-block bg-primary ml-5" style="width: 661px">ADD DELETE UPDATE QUESTIONS</button>
          
          <form class="form-group "  method="POST" action="question_servlet">
            <div class="form-inline mt-4 ml-5 ">
              <label class="form-control " align="left" style="width: 200px;" for="qid"> QUESTION ID :</label>
              <input type="text" name="qid" placeholder="qid" class="form-control  ml-1" id="qid" style="width: 457px;" >
            </div>
            <div class="form-inline mt-2 ml-5">
              <label class="form-control" align="left" style="width: 200px;" for="qstring"> QUESTION STRING :</label>
              <input type="text" name="qstring" placeholder="qstring" class="form-control  ml-1" id="qstring" style="width: 457px; height: 100px;" >
            </div>
            <div class="form-inline mt-2 ml-5">
              <label class="form-control" align="left" style="width: 200px;" for="optiona"> QUESTION OPTION A :</label>
              <input type="text" name="optiona" placeholder="optiona" class="form-control  ml-1" id="optiona" style="width: 457px;" >
              
            </div>
            <div class="form-inline mt-2 ml-5">
              <label class="form-control" align="left" style="width: 200px;" for="optionb"> QUESTION OPTION B :</label>
              <input type="text" name="optionb" placeholder="optionb" class="form-control  ml-1" id="optionb" style="width: 457px;" >
              
            </div>
            <div class="form-inline mt-2 ml-5">
              <label class="form-control" align="left" style="width: 200px;" for="optionc"> QUESTION OPTION C :</label>
              <input type="text" name="optionc" placeholder="optionc" class="form-control  ml-1" id="optionc" style="width: 457px;" >
              
            </div>
            <div class="form-inline mt-2 ml-5">
              <label class="form-control" align="left" style="width: 200px;" for="optiond"> QUESTION OPTION D :</label>
              <input type="text" name="optiond" placeholder="optiond" class="form-control  ml-1" id="optiond" style="width: 457px;" >
              
            </div>
            <div class="form-inline mt-2 ml-5">
              <label class="form-control" for="qcat" align="left" style="width: 200px;" > QUESTION CAT :</label>
              <select class="form-control ml-1" name="qcat" id="qcat" style="width: 456px;">
                <option value="admin">GENERAL KNOWLEDGE</option>
                <option value="student">CURRENT AFFAIRS</option>
              </select>
              
            </div>



            <div class="form-inline mt-2 ml-5">
              <label class="form-control" for="qans" align="left" style="width: 200px;" > CORERECT ANSWER :</label>
              <select class="form-control ml-1" name="qans" id="qans" style="width: 456px;">
                <option value="A">A</option>
                <option value="B">B</option>
                <option value="C">C</option>
                <option value="D">D</option>
              </select>
              
            </div>





            <div class="form-inline mt-2 ml-5">
              <label class="form-control" for="qdif" align="left" style="width: 200px;" > DIFFICULTY :</label>
              <select class="form-control ml-1" name="qdif" id="qdif" style="width: 456px;">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                
              </select>
              
            </div>
            
            
            
            
          </div>
          <div class="col-md-2 d-flex flex-column text-light">
            <input type="submit" name="s1" value="insert" class="btn btn-warning  " style="height: 122px;">
            <input type="submit" name="s1" value="update" class="btn btn-warning mt-3"style="height: 122px;"  >
            <input type="submit" name="s1" value="delete" class="btn btn-warning  mt-3"style="height: 122px;"  >
            <input type="submit" name="s1" value="view" class="btn btn-warning mt-3" style="height: 122px;" >
            
          </div>
        </form>
      </div>
    </div>
    <!-- admin form-->
    <div class="container-fluid">
     
    </div>
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
