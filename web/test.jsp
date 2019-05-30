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
        <title>TEST </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="bootstrap.css">
    </head>
    <body>
       
<%!
int questionid;

public void generatequestionid(){
      try{
        questionid++;
          }                         
          catch(Exception ex ){
                                }  

                                 }
%>

<%
     Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost/testinweb2?", "root", ""); 
           PreparedStatement ps=con.prepareStatement("select * from question where qid=?");
            ps.setInt(1,questionid);
            ResultSet rs=ps.executeQuery();
           
     %>

    

  
      
         


        <div class="jumbotron-fluid bg-light text-center">
    <h1 class="display-4">NUML ONLINE TESTING SERVICES </h1>
</div>

<div class="jumbotron">
    <div class="row">
        <div class="col-md-12"><button type="button" class="btn btn-block bg-primary mb-3 " style="">TEST  </button>
            <div class="jumbotron bg-dark pb-3">
      <div class="row">
        <div class="col-md-10 text-center ">
          <button type="button" class="btn btn-danger">Login Details</button>
          <button type="button" class="btn btn-primary">Student Name :<%="  "+session.getAttribute("studentname")%></button>
         <button type="button" class="btn btn-primary">Student password :<%="  "+session.getAttribute("studentpassword")%></button>
          
        <%  while(rs.next()){
                      
%>
            <div class="form-inline mt-4 ml-5 ">
              <label class="form-control " align="left" style="width: 200px;" for="qid"> QUESTION ID :</label>
              <input type="text" name="qid" placeholder="qid" class="form-control  ml-1" id="qid" style="width: 457px;" value="<%=" "+rs.getInt(1)%>" disabled >
            </div>
            <div class="form-inline mt-2 ml-5">
              <label class="form-control" align="left" style="width: 200px;" for="qstring"> QUESTION STRING :</label>
              <input type="text" name="qstring" pattern="[0-9]{9}" placeholder="qstring" class="form-control  ml-1" id="qstring" style="width: 457px; height: 100px;" value="<%=rs.getString(2)%>" disabled >
            </div>
            <div class="form-inline mt-2 ml-5">
              <label class="form-control" align="left" style="width: 200px;" for="optiona"> QUESTION OPTION A :</label>
              <input type="text" name="optiona" placeholder="optiona" class="form-control  ml-1" id="optiona" style="width: 457px;" value="<%=" "+rs.getString(3)%>" disabled>
              
            </div>
            <div class="form-inline mt-2 ml-5">
              <label class="form-control" align="left" style="width: 200px;" for="optionb"> QUESTION OPTION B :</label>
              <input type="text" name="optionb" placeholder="optionb" class="form-control  ml-1" id="optionb" style="width: 457px;" value="<%=" "+rs.getString(4)%>" disabled>
              
            </div>
            <div class="form-inline mt-2 ml-5">
              <label class="form-control" align="left" style="width: 200px;" for="optionc"> QUESTION OPTION C :</label>
              <input type="text" name="optionc" placeholder="optionc" class="form-control  ml-1" id="optionc" style="width: 457px;" value="<%=" "+rs.getString(5)%>" disabled >
              
            </div>
            <div class="form-inline mt-2 ml-5">
              <label class="form-control" align="left" style="width: 200px;" for="optiond"> QUESTION OPTION D :</label>
              <input type="text" name="optiond" placeholder="optiond" class="form-control  ml-1" id="optiond" style="width: 457px;" value="<%=" "+rs.getString(6)%>" disabled>
              
            </div>


            <div class="form-inline mt-2 ml-5">
              <label class="form-control" for="qcat" align="left" style="width: 200px;" > QUESTION CAT :</label>
              <input type="text" name="qcat" placeholder="qcat" class="form-control  ml-1" id="qcat" style="width: 457px;" value="<%=" "+rs.getString(7)%>" disabled>
              
            </div>

              <div class="form-inline mt-2 ml-5">
              <label class="form-control" for="qdif" align="left" style="width: 200px;" > DIFFICULTY :</label>
              <input type="text" name="qdif" placeholder="qdif" class="form-control  ml-1" id="qdif" style="width: 457px;" value="<%=" "+rs.getString(9)%>" disabled>
              
            </div>

           


<% } %>





        </div>
    </div>


    <div class="row mt-3">
    
     <div class="col-md-10 text-center ml-5">
       <form action="" method="POST">
        <div class="form-inline">
  <label class="form-control" for="ans" align="left" style="width: 200px;" > Select Answer :</label>
  <select class="form-control ml-1" name="ans" style="width: 457px;">
    <option value="A">A</option>
    <option value="B">B</option>
    <option value="C">C</option>
    <option value="D">D</option>

  </select>
</div>
<div class=" mt-2 ml-5">
  <input type="submit" name="s1" value="Submit" class="btn btn-success">
  <input type="submit" name="s1" value="Next Question" class="btn btn-success">
  <input type="submit" name="s1" value="Previous Question" class="btn btn-success">
  

</div>
     </div>
   </form>
    </div>
</div>
</div>





</div>
</body>
</html>