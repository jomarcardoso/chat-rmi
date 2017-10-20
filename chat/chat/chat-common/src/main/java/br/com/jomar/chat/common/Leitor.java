package br.com.jomar.chat.common;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/**
 * @author Jomar
 */
public class Leitor extends Usuario {

    private String ip;
    private int porta;    

    public Leitor(String ip, int porta, String nome) {
        super(nome);
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

}
