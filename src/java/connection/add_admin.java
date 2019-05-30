/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asd
 */
public class add_admin extends HttpServlet {

    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try{
             response.setContentType("text/html");
             PrintWriter out=response.getWriter();
            
               connection conn=new connection();
    
    String requesttype=request.getParameter("s1");
  
    if(requesttype.equals("insert")){
        int uid=  Integer.parseInt(request.getParameter("userid"));
    String uname=  request.getParameter("username");
    String upass=  request.getParameter("password");
    String utype=  request.getParameter("type");
    
 PreparedStatement ps=conn.select_prepared("insert into user (uid,uname,upass,utype) values(?,?,?,?)");
      
      ps.setInt(1,uid);
      ps.setString(2,uname);
      ps.setString(3,upass);
      ps.setString(4,utype);
      int affectedrows=ps.executeUpdate();
      if(affectedrows>=1){
           response.sendRedirect("actioncopmpleted.jsp");
      }
      
      }
    
    else if(requesttype.equals("delete")){
         int uid=  Integer.parseInt(request.getParameter("userid"));
    String uname=  request.getParameter("username");
    String upass=  request.getParameter("password");
    String utype=  request.getParameter("type");
    int rowsaffected=conn.delete("DELETE  FROM `user` WHERE uid="+uid);
    
    if(rowsaffected>0){
           response.sendRedirect("actioncopmpleted.jsp");
     }
      
      }
    
    else if(requesttype.equals("update")){
         int uid=  Integer.parseInt(request.getParameter("userid"));
    String uname=  request.getParameter("username");
    String upass=  request.getParameter("password");
    String utype=  request.getParameter("type");
       PreparedStatement ps=conn.select_prepared("update user set uname=?, upass=?, utype=? where uid="+uid);
      ps.setString(1,uname);
      ps.setString(2,upass);
      ps.setString(3,utype);
     
      int affectedrows=ps.executeUpdate();
      if(affectedrows>=1){
            response.sendRedirect("actioncopmpleted.jsp");
      }
     
     
      
      }
    
    
    
    else if(requesttype.equals("view")){
        
         PreparedStatement ps=(PreparedStatement) conn.select_prepared("select * from user");
      ResultSet rs= ps.executeQuery();
         
          String html=" <head>\n" +
"        <title>TODO supply a title</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap.css\">\n" +
"    </head>\n" +
"    <body><div class=\"jumbotron-fluid bg-light text-center\">\n" +
"    <h1 class=\"display-4\">NUML ONLINE TESTING SERVICES </h1>\n" +
"</div><div class=\"jumbotron\">\n" +
"    <div class=\"row\">\n" +
"        <div class=\"col-md-12\"><button type=\"button\" class=\"btn btn-block bg-primary mb-3 \" style=\"\">ALL USERS (ADMINS AND STUDENTS) </button>\n" +
"            <table class=\"table table-striped table-dark\">\n" +
"  <thead>\n" +
"    <tr>\n" +
"      <th scope=\"col\">USER ID</th>\n" +
"      <th scope=\"col\">USER NAME</th>\n" +
"      <th scope=\"col\">USER PASSWORD</th>\n" +
"      <th scope=\"col\">USER TYPE</th>\n" +
"    </tr>\n" +
"  </thead>\n" +
"  <tbody>";
      while(rs.next()){
          html+="<tr>\n" +
"      <th scope=\"row\">"+rs.getInt(1)+"</th>\n" +
"      <td>"+rs.getString(2)+"</td>\n" +
"      <td>"+rs.getString(3)+"</td>\n" +
"      <td>@"+rs.getString(4)+"</td>\n" +
"    </tr>";
 
      } 
    html+=" </tbody>\n" +
"</table>\n" +
"        </div>\n" +
"    </div>\n" +
"</div></body>\n" +
"</html>";
      out.print(html);
    }
    
    
    else if(requesttype.equals("startest")){
       
        //response.sendRedirect("test.jsp");
      RequestDispatcher rd=request.getRequestDispatcher("test.jsp");
      rd.forward(request, response);
    }
    
    
    
    
    
    
    
    
    }
    
    
      catch(Exception ex){
          
      }
      
    }

    

}
