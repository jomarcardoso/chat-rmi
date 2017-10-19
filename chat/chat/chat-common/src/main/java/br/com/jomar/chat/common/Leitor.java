package br.com.jomar.chat.common;

import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/**
 * @author Jomar
 */
public class Leitor implements Serializable {

    private int porta;
    private String nome;

    public Leitor(int porta, String nome) {
        this.porta = porta;
        this.nome = nome;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
