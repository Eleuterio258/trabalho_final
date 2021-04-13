package com.enigma.model;

public class DocumentoTipo {

    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public DocumentoTipo() {
    }

    public DocumentoTipo(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "DocumentoTipo{" + "id=" + id + ", nome=" + nome + '}';
    }

}
