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

    public List listar() {
        List<Documento> data = new ArrayList<>();
        try {
            con = conn.getConnection();
            ps = con.prepareStatement("select * from Documento");
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

    public int agregar(Documento documento) {
        int r = 0;
        String sql = "insert into Documento(nome,senha,celular,email)values(?,?,?,?,?,?)";
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

    public int Actualizar(Documento documento) {
        int r = 0;
        String sql = "update documento set Nombres=?,Correo=?,Telefono=? where Id=?";
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

    public int Delete(int id) {
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
