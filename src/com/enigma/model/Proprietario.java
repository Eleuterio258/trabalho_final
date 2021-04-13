/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enigma.model;

public class Proprietario {

    private int id;
    private String nome, celular, morrada,email;

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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getMorrada() {
        return morrada;
    }

    public void setMorrada(String morrada) {
        this.morrada = morrada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Proprietario() {
    }

    public Proprietario(int id, String nome, String celular, String morrada, String email) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
        this.morrada = morrada;
        this.email = email;
    }

     
}
