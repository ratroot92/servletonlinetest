package connection;


import connection.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asd
 */
public class userlogin {
    int uid;
    String uname;
    String upass;
    String utype;
    userlogin(){
       uid=0;
       uname="";
       upass="";
       utype="";
    }
    
}
class userlogindao{

 
    public int validatelogin(userlogin obj) throws SQLException{
         connection conn=new connection();
         int flag=0;
        try{
            
           int a=0;
            String b="";
            String c="";
              String d="";
       ResultSet rs= conn.select("select * from user");
         while(rs.next()){
             a=rs.getInt(1);
             b=rs.getString(2);
             c=rs.getString(3);
             d=rs.getString(4);
             if(b.equals(obj.uname) && c.equals(obj.upass)){
                 flag=1;
                 break;
             }
         }
         System.out.print("uname = "+b+"upass ="+c);
        }
        
        catch(SQLException ex ){
            System.out.println(ex.getMessage());
        }
        return flag;
    }

public String gettype(userlogin obj){
     
         String a="";
        try{
            connection conn=new connection();
           
             
       PreparedStatement ps= conn.select_prepared("select * from user where uname=?");
       ps.setString(1,obj.uname);
       ResultSet rs=ps.executeQuery();
         while(rs.next()){
             a=rs.getString("utype");
            
             
         }
         System.out.print("utype = "+a);
        }
        catch(SQLException ex ){
            System.out.println(ex.getMessage());
        }
        return a;
}

}
