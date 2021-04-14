package com.enigma.dao;

import com.enigma.config.Conn;
import com.enigma.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conn conn = new Conn();
    Usuario p = new Usuario();

    public List list() {
        List<Usuario> data = new ArrayList<>();
        try {
            con = conn.getConnection();
            ps = con.prepareStatement("select * from usuario");
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario p = new Usuario();
                p.setId(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setEmail(rs.getString(3));
                p.setSenha(rs.getString(4));
                p.setCelular(rs.getString(5));
                p.setRole(rs.getString(6));
                p.setLoc(rs.getString(7));
                data.add(p);
            }
        } catch (Exception e) {
        }
        return data;
    }

    public int create(Usuario usuario) {
        int r = 0;
        String sql = "INSERT INTO usuario (nome, senha, celular, email, role, local) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = conn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getSenha());
            ps.setString(5, usuario.getCelular());
            ps.setString(4, usuario.getRole());
            ps.setString(5, usuario.getLoc());
            r = ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
        }
        return r;
    }

    public int update(Usuario usuario) {
        int r = 0;
        String sql = "update usuario set nome=?, senha=?, celular=?, email=?, role=?, local=? where Id=?";
        try {
            con = conn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getCelular());
            ps.setInt(5, usuario.getId());
            r = ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
        }
        return r;
    }

    public int delete(int id) {
        int r = 0;
        String sql = "delete from usuario where Id=" + id;
        try {
            con = conn.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    public boolean login(String usuario, String senha) {
        boolean isUser = false;
        String sql =  "SELECT * FROM usuario WHERE nome='" + usuario + "' && senha='" + senha+ "'";
        try {
            con = conn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                isUser = true;
                System.out.println("User authenticated successfully");
            } else {
                System.out.println("Invalid username or password!");
            }
        } catch (Exception e) {
            System.out.println("DB related Error");
            e.printStackTrace();
        }
        return isUser;

    }
}
