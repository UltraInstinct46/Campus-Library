/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Conection;
import java.sql.*;

/**
 *
 * @author LENOVO
 */
public class ConnectionC1 {

    public static ConnectionC1 getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public Connection con;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library","root", "");
        
        if (con!=null){
            System.out.println("Succesfully Connected");
        
      
        }
            
    }catch(Exception e){
        System.out.println(e);
        System.out.println("not connected");
    
    }
}

    public PreparedStatement prepareStatement(String select__from_multiuser_login_where_userna) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}