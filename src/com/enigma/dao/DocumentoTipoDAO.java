package com.enigma.dao;



import com.enigma.config.Conn;
import com.enigma.model.DocumentoTipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DocumentoTipoDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conn conn = new Conn();
    DocumentoTipo p = new DocumentoTipo();

    public List list() {
        List<DocumentoTipo> data = new ArrayList<>();
        try {
            con = conn.getConnection();
            ps = con.prepareStatement("select * from documentotipo");
            rs = ps.executeQuery();
            while (rs.next()) {
                DocumentoTipo p = new DocumentoTipo();
                p.setId(rs.getInt(1));
                p.setNome(rs.getString(2));

                data.add(p);
            }
        } catch (Exception e) {
        }
        return data;
    }

    public int create(DocumentoTipo documentoTipo) {
        int r = 0;
        String sql = "insert into usuario(nome)values(?)";
        try {
            con = conn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, documentoTipo.getNome());

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

    public int update(DocumentoTipo documentoTipo) {
        int r = 0;
        String sql = "update documentotipo set nome=? where Id=?";
        try {
            con = conn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, documentoTipo.getNome());

            ps.setInt(2, documentoTipo.getId());
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
        String sql = "delete from documentotipo where Id=" + id;
        try {
            con = conn.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
