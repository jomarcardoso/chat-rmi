package br.com.jomar.chat.common;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/**
 * @author Jomar
 */
public class Leitor implements Serializable {

    private String ip;
    private int porta;
    private String nome;

    public Leitor(String ip, int porta, String nome) {
        this.ip = ip;
        this.porta = porta;
        this.nome = nome;        
    }
    
    public String login(IServiceLeitor service) throws RemoteException {
       if(service.login(this)) {
           return "Login realizado com sucesso";           
       } else {
           return "Login falhou, provavelmente nome repetido";
       }
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }    

}
