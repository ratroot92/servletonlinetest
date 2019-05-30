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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asd
 */
public class question_servlet extends HttpServlet {

    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try{
             response.setContentType("text/html");
             PrintWriter out=response.getWriter();
            
               connection conn=new connection();
    
    String requesttype=request.getParameter("s1");
   
    if(requesttype.equals("insert")){
      
   int a=  Integer.parseInt(request.getParameter("qid"));
    String b=  request.getParameter("qstring");
    String c=  request.getParameter("optiona");
    String d=  request.getParameter("optionb");
    String e=  request.getParameter("optionc");
    String f=  request.getParameter("optiond");
    String g=  request.getParameter("qcat");
    String h=  request.getParameter("qans");
    int i=  Integer.parseInt(request.getParameter("qid"));
    
 PreparedStatement ps=conn.select_prepared("INSERT INTO `question`(`qid`, `qstring`, `optiona`, `optionb`, `optionc`, `optiond`, `qcat`, `qans`, `qdif`) VALUES (?,?,?,?,?,?,?,?,?)");
      
      ps.setInt(1,a);
      ps.setString(2,b);
      ps.setString(3,c);
      ps.setString(4,d);
      ps.setString(5,e);
      ps.setString(6,f);
      ps.setString(7,g);
      ps.setString(8,h);
       ps.setInt(9,i);
           
      int affectedrows=ps.executeUpdate();
      if(affectedrows>=1){
            response.sendRedirect("actioncopmpleted.jsp");
      }
      
      }
    
    else if(requesttype.equals("delete")){
          int a=  Integer.parseInt(request.getParameter("qid"));
    
    int i=  Integer.parseInt(request.getParameter("qid"));
    
    
    int rowsaffected=conn.delete("DELETE  FROM `user` WHERE uid="+a);
    
    if(rowsaffected>0){
           response.sendRedirect("actioncopmpleted.jsp");
     }
      
      }
    
    else if(requesttype.equals("update")){
          int a=  Integer.parseInt(request.getParameter("qid"));
    String b=  request.getParameter("qstring");
    String c=  request.getParameter("optiona");
    String d=  request.getParameter("optionb");
    String e=  request.getParameter("optionc");
    String f=  request.getParameter("optiond");
    String g=  request.getParameter("qcat");
    String h=  request.getParameter("qans");
    int i=  Integer.parseInt(request.getParameter("qid"));
    
    
    
       PreparedStatement ps=conn.select_prepared("UPDATE `question` SET `qstring`=?,`optiona`=?,`optionb`=?,`optionc`=?,`optiond`=?,`qcat`=?,`qans`=?,`qdif`=?  WHERE `qid`="+a);
      ps.setString(1,b);
      ps.setString(2,c);
      ps.setString(3,d);
      ps.setString(4,e);
      ps.setString(5,f);
      ps.setString(6,g);
      ps.setString(7,h);
      ps.setInt(8,i); 
         
     
      int affectedrows=ps.executeUpdate();
      if(affectedrows>=1){
            response.sendRedirect("actioncopmpleted.jsp");
      }
     
     
      
      }
    
    
    
    else if(requesttype.equals("view")){
        
         PreparedStatement ps=(PreparedStatement) conn.select_prepared("select * from question");
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
"      <th scope=\"col\">QUESTION ID</th>\n" +
"      <th scope=\"col\">QUESTION STRING</th>\n" +
"      <th scope=\"col\">OPTION A</th>\n" +
"      <th scope=\"col\">OPTION B</th>\n" +     
"      <th scope=\"col\">OPTION C</th>\n" +
"      <th scope=\"col\">OPTION D</th>\n" +
"      <th scope=\"col\">QUESTION CAT</th>\n" +
"      <th scope=\"col\">CORRECT OPTION</th>\n" +
"      <th scope=\"col\">DIFFICULTY</th>\n" +
                  
"    </tr>\n" +
"  </thead>\n" +
"  <tbody>";
      while(rs.next()){
          html+="<tr>\n" +
"      <th scope=\"row\">"+rs.getInt(1)+"</th>\n" +
"      <td>"+rs.getString(2)+"</td>\n" +
"      <td>"+rs.getString(3)+"</td>\n" +
"      <td>"+rs.getString(4)+"</td>\n" +
"       <td>"+rs.getString(5)+"</td>\n" +
"      <td>"+rs.getString(6)+"</td>\n" +
"      <td>"+rs.getString(7)+"</td>\n" +
"        <td>"+rs.getString(8)+"</td>\n" +
"      <td>"+rs.getString(9)+"</td>\n" +
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
    
    
    
    
    
    
    
    
    
    
    
    }
    
    
      catch(Exception ex){
          
      }
    }

   
   
}
