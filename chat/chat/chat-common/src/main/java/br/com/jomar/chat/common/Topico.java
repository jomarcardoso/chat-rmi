package br.com.jomar.chat.common;

import java.io.Serializable;

/**
 * @author Jomar
 */
public class Topico implements Serializable {

    private String nome;

    public Topico(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
