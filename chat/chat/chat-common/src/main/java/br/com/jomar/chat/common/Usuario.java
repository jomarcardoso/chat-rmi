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
    private String ip;
    private int porta;    

    public Usuario(String ip, int porta) {
        this.ip = ip;
        this.porta = porta;               
    }    

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }   
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
