package br.com.jomar.chat.client;

import java.io.Serializable;

/**
 * @author Jomar
 */
public class Escritor implements Serializable {

    public String nome;

    public Escritor(String nome) {
        this.nome = nome;
    }

}
