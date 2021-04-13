package com.enigma.dao;

import com.enigma.config.Conn;
import com.enigma.model.Proprietario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProprietarioDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conn conn = new Conn();
    Proprietario p = new Proprietario();

    public List listar() {
        List<Proprietario> data = new ArrayList<>();
        try {
            con = conn.getConnection();
            ps = con.prepareStatement("select * from proprietario");
            rs = ps.executeQuery();
            while (rs.next()) {
                Proprietario p = new Proprietario();
                p.setId(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setCelular(rs.getString(3));
                p.setEmail(rs.getString(4));
                p.setMorrada(rs.getString(5));
                data.add(p);
            }
        } catch (Exception e) {
        }
        return data;
    }

    public int agregar(Proprietario proprietario) {
        int r = 0;
        String sql = "insert into proprietario(nome,senha,celular,email)values(?,?,?,?,?,?)";
        try {
            con = conn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, proprietario.getNome());
            ps.setString(2, proprietario.getCelular());
            ps.setString(3, proprietario.getEmail());
            ps.setString(4, proprietario.getMorrada());

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

    public int Actualizar(Proprietario proprietario) {
        int r = 0;
        String sql = "update proprietario set nome=?  where Id=?";
        try {
            con = conn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, proprietario.getNome());
            ps.setString(2, proprietario.getCelular());
            ps.setString(3, proprietario.getEmail());
            ps.setString(4, proprietario.getMorrada());
            ps.setInt(5, proprietario.getId());
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
        String sql = "delete from proprietario where Id=" + id;
        try {
            con = conn.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
