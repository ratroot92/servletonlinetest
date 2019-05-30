/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class login2 extends HttpServlet {

   
    

   
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
       userlogin obj=new userlogin();
       userlogindao    obj2=new userlogindao();
        int flag=0;
        String utype="";
        PrintWriter out=response.getWriter();
        
         
       Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/testinweb2?", "root", "");
        String username=  request.getParameter("username");
        String password=request.getParameter("password");
            
        
        obj.uname=username;
        obj.upass=password;
        flag=obj2.validatelogin(obj);
        utype=obj2.gettype(obj);
        
        if(flag==1){
            
        
       if(utype.equals("admin")) {
           HttpSession session=request.getSession();
                session.setAttribute("adminname", username);
                session.setAttribute("adminpassword", password);
                //out.println("utype= "+utype);
           RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
           rd.forward(request, response);
           // rd.include(request, response);
       }
       
       
       
       else if(utype.equals("student")){
            HttpSession session=request.getSession();
                session.setAttribute("studentname", username);
                session.setAttribute("studentpassword", password);
                 // out.println("utype= "+utype);
           RequestDispatcher rd=request.getRequestDispatcher("student.jsp");
        rd.forward(request, response);
            //rd.include(request, response);
       }
        }
        
        
       else{
        response.sendRedirect("error.jsp");
       }
    
    }   catch (IOException | ClassNotFoundException | SQLException | ServletException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println(ex.getMessage());
               out.print(ex.getMessage());
        }
    }

    

}
