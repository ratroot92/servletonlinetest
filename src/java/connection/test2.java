/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asd
 */
public class test2 extends HttpServlet {

    
   

   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int a=0;
        String b="";
        String c="";
        String d="";
        String e="";
        String f="";
        String g="";
        String h="";
        int i=0;
        
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost/testinweb2?", "root", ""); 
            
            
            
          
            PreparedStatement ps=con.prepareStatement("select * from question where qid=?");
          //  ps.setInt(1,);
            ResultSet rs=ps.executeQuery();
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
        }
        catch(ClassNotFoundException | SQLException ex ){
            System.out.println(ex.getMessage());
        }
    }

   
   
}
