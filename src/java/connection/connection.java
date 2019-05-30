package connection;




import com.mysql.jdbc.Connection;
import java.sql.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asd
 */
public class connection {
    public static final String url="jdbc:mysql://localhost:3306/testinweb2";
    public static final String user_name="root";
    public static final String user_pass="";
    public static final String driver="com.mysql.jdbc.Driver";
    Connection conn;
    public connection() throws SQLException{
       try{
           conn=(Connection) DriverManager.getConnection(url,user_name,user_pass); 
       }
       catch(SQLException ex ){
           
           System.err.println("Exception Goes Here = "+ex);
       }
     
    }
    
    public PreparedStatement insert(String qry) throws SQLException {
        try{
            Class.forName(driver);
            PreparedStatement ps=conn.prepareStatement(qry);
            return ps;
            
        }
        catch(ClassNotFoundException ex ){
           System.err.println("Exception Goes Here = "+ex);
           return null;
       }
    }
    
    
    public int delete(String qry) {
        int rowsafftected;
        try{
            Class.forName(driver);
            Statement st=conn.createStatement();
          rowsafftected= st.executeUpdate(qry);
            
              
            
            
        }
        catch(ClassNotFoundException | SQLException ex ){
           System.err.println("Exception Goes Here = "+ex);
         return 0;
       }
         
        return rowsafftected;
    }
    
    
     public ResultSet select(String qry) {
        try{
            Class.forName(driver);
            Statement st=conn.createStatement();
           ResultSet rs= st.executeQuery(qry);
           return rs;
            
        }
        catch(ClassNotFoundException | SQLException ex ){
           System.err.println("Exception Goes Here = "+ex);
         return null;
       }

        
    }
    
     
     public PreparedStatement select_prepared(String qry) {
        try{
            Class.forName(driver);
            PreparedStatement ps=conn.prepareStatement(qry);
           return ps;
            
        }
        catch(ClassNotFoundException | SQLException ex ){
           System.err.println("Exception Goes Here = "+ex);
         return null;
       }

        
    }
    
    
    
}
