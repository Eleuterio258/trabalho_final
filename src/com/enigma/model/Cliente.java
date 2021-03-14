package com.enigma.model;

import java.util.ArrayList;

import java.util.Date;


public class Cliente {


    private String id;
    private String documento;
    private String nome;
    private String contacto;
    private String email;
    private String endereco;
    private String status;
    private Date createdAt;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", documento=" + documento + ", nome=" + nome + ", contacto=" + contacto + ", email=" + email + ", endereco=" + endereco + ", status=" + status + ", createdAt=" + createdAt + '}';
    }

}
