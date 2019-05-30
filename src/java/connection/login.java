/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author asd
 */
public class login extends HttpServlet {

   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        String a,b,c="";
        int flag=0;
        PrintWriter out=response.getWriter();
        
         
       Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/testinweb2?", "root", "");
        String username=  request.getParameter("username");
        String password=request.getParameter("password");
            String trim1 = username.trim();
            String trim2 = password.trim();
        if(trim1!=null && trim2!=null){
            
        Statement st=con.createStatement();
           ResultSet rs =st.executeQuery("select * from user"); 
                while(rs.next()){
                    a=rs.getString("uname");
                    b=rs.getString("upass");
                    c=rs.getString("utype");
                    
                    if(b.equals(password) && a.equals(username)){
                        flag=1;
                       
                    }
                   
                }
               if(flag==1 &&c.equals("admin") ){
                    HttpSession session=request.getSession();
                session.setAttribute("adminname", username);
                session.setAttribute("adminpassword", password);
                  RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
rd.forward(request,response);
               
               }
               else if(flag==1 && c.equals("student")){
                    HttpSession session=request.getSession();
                session.setAttribute("studentname", username);
                session.setAttribute("studentpassword", password);
                    RequestDispatcher rd = request.getRequestDispatcher("student.jsp");
rd.forward(request,response);
               }
            }
        
         
        
        else{
            out.println("no values ");
        }
    
    }   catch (Exception ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println(ex.getMessage());
               out.print(ex.getMessage());
        }
    }
    

    
}

