/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conection;
import java.sql.*;
/**
 *
 * @author killua
 */
public class Connectionc {
    public Connection con;
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library","root","");
            
            if(con!=null){
                System.out.println("successfully connected");
                
                
            }
        } catch(Exception e){
            System.out.println(e);
            
            System.out.println("Not Connected");
        }
    }
}


