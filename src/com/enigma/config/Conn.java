package com.enigma.config;
import java.sql.Connection;
import java.sql.DriverManager;
public class Conn {
    String url="jdbc:mysql://localhost:3306/bd_achados";
    String user="root",pass="";    
    Connection con;
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {            
        }
        return con;
    }
}
