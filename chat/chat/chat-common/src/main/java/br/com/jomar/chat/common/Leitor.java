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

    public Leitor(String ip, int porta) {
        super(ip, porta);
    }

 

}
