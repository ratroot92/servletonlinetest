/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asd
 */
public class test_servlet extends HttpServlet {

   

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        try {
         connection   conn = new connection();
         
int a=0;
String b="";
String c="";
String d="";
String e="";
String f="";
String g="";
String h="";
int  i=0;
       

    PrintWriter out=response.getWriter();

       PreparedStatement ps=(PreparedStatement) conn.select_prepared("select * from question where qid=1");
      ResultSet rs= ps.executeQuery();
      while(rs.next()){
                       a=rs.getInt(1);
      b=rs.getString(2);
      c=rs.getString(3);
      d=rs.getString(4);
      e=rs.getString(5);
      f=rs.getString(6);
      g=rs.getString(7);
      h=rs.getString(8);
      i=rs.getInt(9);
  }


           String html="<html>\n" +
" <head>\n" +
"        <title>TEST </title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap.css\">\n" +
"    </head>\n" +
"    <body>\n" +
"        \n" +
"           \n" +
"\n" +
"\n" +
"        <div class=\"jumbotron-fluid bg-light text-center\">\n" +
"    <h1 class=\"display-4\">NUML ONLINE TESTING SERVICES </h1>\n" +
"</div>\n" +
"\n" +
"<div class=\"jumbotron\">\n" +
"    <div class=\"row\">\n" +
"        <div class=\"col-md-12\"><button type=\"button\" class=\"btn btn-block bg-primary mb-3 \" style=\"\">TEST  </button>\n" +
"            <div class=\"jumbotron bg-dark pb-3\">\n" +
"      <div class=\"row\">\n" +
"        <div class=\"col-md-10 text-center \">\n" +
"          <button type=\"button\" class=\"btn btn-block bg-primary ml-5\" style=\"width: 661px\">TEST</button>\n" +
"          \n" +
"          <form class=\"form-group \"  method=\"POST\" action=\"\">\n" +
"            <div class=\"form-inline mt-4 ml-5 \">\n" +
"              <label class=\"form-control \" align=\"left\" style=\"width: 200px;\" for=\"qid\"> QUESTION ID :</label>\n" +
"              <input type=\"text\" name=\"qid\" placeholder=\"qid\" class=\"form-control  ml-1\" id=\"qid\" style=\"width: 457px;\" value=\" \" disabled >\n" +
"            </div>\n" +
"            <div class=\"form-inline mt-2 ml-5\">\n" +
"              <label class=\"form-control\" align=\"left\" style=\"width: 200px;\" for=\"qstring\"> QUESTION STRING :</label>\n" +
"              <input type=\"text\" name=\"qstring\" placeholder=\"qstring\" class=\"form-control  ml-1\" id=\"qstring\" style=\"width: 457px; height: 100px;\" value=\"<%=b%>\" disabled >\n" +
"            </div>\n" +
"            <div class=\"form-inline mt-2 ml-5\">\n" +
"              <label class=\"form-control\" align=\"left\" style=\"width: 200px;\" for=\"optiona\"> QUESTION OPTION A :</label>\n" +
"              <input type=\"text\" name=\"optiona\" placeholder=\"optiona\" class=\"form-control  ml-1\" id=\"optiona\" style=\"width: 457px;\" value=\"<%=c%>\" disabled>\n" +
"              \n" +
"            </div>\n" +
"            <div class=\"form-inline mt-2 ml-5\">\n" +
"              <label class=\"form-control\" align=\"left\" style=\"width: 200px;\" for=\"optionb\"> QUESTION OPTION B :</label>\n" +
"              <input type=\"text\" name=\"optionb\" placeholder=\"optionb\" class=\"form-control  ml-1\" id=\"optionb\" style=\"width: 457px;\" value=\"<%=d%>\" disabled>\n" +
"              \n" +
"            </div>\n" +
"            <div class=\"form-inline mt-2 ml-5\">\n" +
"              <label class=\"form-control\" align=\"left\" style=\"width: 200px;\" for=\"optionc\"> QUESTION OPTION C :</label>\n" +
"              <input type=\"text\" name=\"optionc\" placeholder=\"optionc\" class=\"form-control  ml-1\" id=\"optionc\" style=\"width: 457px;\" value=\"<%=e%>\" disabled >\n" +
"              \n" +
"            </div>\n" +
"            <div class=\"form-inline mt-2 ml-5\">\n" +
"              <label class=\"form-control\" align=\"left\" style=\"width: 200px;\" for=\"optiond\"> QUESTION OPTION D :</label>\n" +
"              <input type=\"text\" name=\"optiond\" placeholder=\"optiond\" class=\"form-control  ml-1\" id=\"optiond\" style=\"width: 457px;\" value=\"<%=f%>\" disabled>\n" +
"              \n" +
"            </div>\n" +
"\n" +
"\n" +
"            <div class=\"form-inline mt-2 ml-5\">\n" +
"              <label class=\"form-control\" for=\"qcat\" align=\"left\" style=\"width: 200px;\" > QUESTION CAT :</label>\n" +
"              <input type=\"text\" name=\"qcat\" placeholder=\"qcat\" class=\"form-control  ml-1\" id=\"qcat\" style=\"width: 457px;\" value=\"<%=g%>\" disabled>\n" +
"              \n" +
"            </div>\n" +
"\n" +
"              <div class=\"form-inline mt-2 ml-5\">\n" +
"              <label class=\"form-control\" for=\"qdif\" align=\"left\" style=\"width: 200px;\" > DIFFICULTY :</label>\n" +
"              <input type=\"text\" name=\"qdif\" placeholder=\"qdif\" class=\"form-control  ml-1\" id=\"qdif\" style=\"width: 457px;\" value=\"<%=i%>\" disabled>\n" +
"              \n" +
"            </div>\n" +
"\n" +
"            <input type=\"submit\" name=\"starttest\" class=\"btn btn-warning \">\n" +
"</form>\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"        </div>\n" +
"    </div>\n" +
"</div></body>\n" +
"</html>\n" +
"";
   
   out.print(html);

}
    catch(IOException | SQLException ex ){
    System.out.println(ex.getMessage());
               out.print(ex.getMessage());
}
    }}

