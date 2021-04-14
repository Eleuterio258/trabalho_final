package com.enigma.dao;

import com.enigma.config.Conn;
import com.enigma.model.Documento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DocumentoDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conn conn = new Conn();
    Documento p = new Documento();

    public List list() {
        List<Documento> data = new ArrayList<>();
        try {
            con = conn.getConnection();
            ps = con.prepareStatement("select * from documento");
            rs = ps.executeQuery();
            while (rs.next()) {
                Documento p = new Documento();
                p.setId(rs.getInt(1));

                data.add(p);
            }
        } catch (Exception e) {
        }
        return data;
    }
    
        public List listTipo() {
        List<Documento> data = new ArrayList<>();
        try {
            con = conn.getConnection();
            ps = con.prepareStatement("select * from documentoTipo");
            rs = ps.executeQuery();
            while (rs.next()) {
                Documento p = new Documento();
                p.setId(rs.getInt(1));

                data.add(p);
            }
        } catch (Exception e) {
        }
        return data;
    }

    public int create(Documento documento) {
        int r = 0;
        String sql = "INSERT INTO documento (tipo,proprietario,validade) VALUES (?,?,?,?)";
        try {
            con = conn.getConnection();
            ps = con.prepareStatement(sql);

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

    public int update(Documento documento) {
        int r = 0;
        String sql = "UPDATE documento SET tipo=? proprietario=?,validade=? WHERE  id=?";
        try {
            con = conn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(5, documento.getId());
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
        String sql = "delete from documento where Id=" + id;
        try {
            con = conn.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
