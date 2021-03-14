/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enigma.model;

import java.util.ArrayList;

public class Usuario {

    private Integer id;
    private String nome;
    private String email;
    private String endereco;
    private String tipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList getUsurios() {
        return usurios;
    }

    public void setUsurios(ArrayList usurios) {
        this.usurios = usurios;
    }

    ArrayList usurios;

    void selectAll() {
    }

    void selectById() {
    }

    void delete() {
    }

    void update() {
    }

    void selectEmail() {
    }

    void selectLast() {
    }

    void login(String email, String senha) {
    }
}
