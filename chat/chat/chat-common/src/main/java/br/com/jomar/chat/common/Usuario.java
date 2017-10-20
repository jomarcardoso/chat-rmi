/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jomar.chat.common;

import java.io.Serializable;

/**
 *
 * @author jomar.cardoso
 */
public abstract class Usuario implements Serializable {
    
    private String nome;    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
