package com.enigma.controller.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.enigma.model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {

    private Connection conn;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/ecommerce";
    private static final String USER = "root";
    private static final String PASS = "";
    private Connection connection;

    public ClienteDAO() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conexão");
        }
    }

    public List<Cliente> listar() {
        String sql = "SELECT *from clients";

        List<Cliente> clientes = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                Cliente cli = new Cliente();
                cli.setId(result.getString("id"));
                cli.setDocumento(result.getString("documento"));
                cli.setNome(result.getString("nome"));
                cli.setContacto(result.getString("contacto"));
                cli.setEmail(result.getString("email"));
                cli.setEndereco(result.getString("endereco"));
                cli.setStatus(result.getString("status"));
                cli.setCreatedAt(result.getDate("createdAt"));
                clientes.add(cli);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }

    public boolean inserir(Cliente cliente) {
        String sql = "INSERT INTO clients (documento,nome,contacto,email,endereco,status) values(?,?,?,?,?,?) ";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getDocumento());
            stmt.setString(1, cliente.getNome());
            stmt.setString(1, cliente.getContacto());
            stmt.setString(1, cliente.getEmail());
            stmt.setString(1, cliente.getEndereco());
            stmt.setString(1, cliente.getStatus());
            stmt.setDate(1, (Date) cliente.getCreatedAt());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean alterar(Cliente cliente) {
        String sql = "UPDATE  clients SET documento=?,SET nome=?,SET contacto=?,SET email=?,SET endereco=?,SET status=? WHERE id=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getDocumento());
            stmt.setString(1, cliente.getNome());
            stmt.setString(1, cliente.getContacto());
            stmt.setString(1, cliente.getEmail());
            stmt.setString(1, cliente.getEndereco());
            stmt.setString(1, cliente.getStatus());
            stmt.setDate(1, (Date) cliente.getCreatedAt());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Integer id) {
        String sql = "DELETE FROM clients WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
