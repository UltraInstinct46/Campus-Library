/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conection;
import java.sql.*;
import java.sql.DriverManager;


/**
 *
 * @author killua
 */
public class Connectionc {
    public static Connection con;
    public static Connection setKoneksi(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library","root","");
            
            if(con!=null){
                System.out.println("successfully connected");
                
                
            }
        } catch(Exception e){
            System.out.println(e);
            
            System.out.println("Not Connected");
        }
        return con;
    }
}


