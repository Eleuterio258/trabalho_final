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

    public List listar() {
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
                p.setRole(rs.getInt(6));
                p.setLoc(rs.getInt(7));
                data.add(p);
            }
        } catch (Exception e) {
        }
        return data;
    }

    public int agregar(Usuario usuario) {
        int r = 0;
        String sql = "insert into usuario(nome,senha,celular,email)values(?,?,?,?,?,?)";
        try {
            con = conn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getSenha());
            ps.setString(5, usuario.getCelular());

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

    public int Actualizar(Usuario usuario) {
        int r = 0;
        String sql = "update usuario set Nombres=?,Correo=?,Telefono=? where Id=?";
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

    public int Delete(int id) {
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
        public boolean login(String email ,String senha) {
      
        String sql = "SELECT * FROM  usuario  WHERE nome=? AND senha=?";
        try {
            con = conn.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
        } catch (Exception e) {
        }
        return true;
    }
}
