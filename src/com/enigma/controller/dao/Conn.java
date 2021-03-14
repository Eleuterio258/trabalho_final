package dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author Antonio joao zimila
 */
public class Conn {

    public static Connection getConexao() {
        String URL = "jdbc:mysql://localhost:3306/spa";
        String user = "root";
        String senha = "";
        try {
            Connection conection = DriverManager.getConnection(URL, user, senha);
            System.out.println(conection);
            return conection;
        } catch (SQLException ex) {
            // Logger.getLogger(ConexaoSql.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return null;
    }

    public static void close(Connection conection) {

        try {
            if (conection != null) {
                conection.close();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void close(Connection conection, Statement stmt) {
        close(conection);
        try {
            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static void close(Connection conection, Statement stmt, ResultSet rs) {
        close(conection, stmt);
        try {
            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
