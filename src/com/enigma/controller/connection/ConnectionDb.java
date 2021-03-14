package com.enigma.controller.connection;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionDb {

    private Connection conn;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/ecommerce";
    private static final String USER = "root";
    private static final String PASS = "";

    public ConnectionDb() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
          JOptionPane.showMessageDialog(null,"Erro ao conexão");
        }
    }

    public void closeConnection() {

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {

            }
        }

    }

    public boolean validarLogin(String email, String password) {
        String sql = "SELECT * FROM users WHERE  email='" + email + "'AND password='" + password + "'";
        try {
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            if (res.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
}
