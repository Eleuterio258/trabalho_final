package com.enigma.model;

import java.util.Date;

public class Documento {

    private int id;
    private DocumentoTipo nome;
    private Date validade;
    private int estado;

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    private Proprietario proprietario;

    public Documento() {
    }

    public int getId() {
        return id;
    }

    public DocumentoTipo getNome() {
        return nome;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public Documento(int id, DocumentoTipo nome, Date validade, int estado, Proprietario proprietario) {
        this.id = id;
        this.nome = nome;
        this.validade = validade;
        this.estado = estado;
        this.proprietario = proprietario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(DocumentoTipo nome) {
        this.nome = nome;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

  

}
