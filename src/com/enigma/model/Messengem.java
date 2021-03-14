package model;

import com.enigma.model.Usuario;
import java.util.Date;

public class Messengem {

    String id;
    Date horaEnvio;
    Usuario usuario;
    String conteudos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getHoraEnvio() {
        return horaEnvio;
    }

    public void setHoraEnvio(Date horaEnvio) {
        this.horaEnvio = horaEnvio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getConteudos() {
        return conteudos;
    }

    public void setConteudos(String conteudos) {
        this.conteudos = conteudos;
    }
    
    

}
