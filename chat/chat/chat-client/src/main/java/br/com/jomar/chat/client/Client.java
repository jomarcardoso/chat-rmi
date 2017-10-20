/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jomar.chat.client;

import br.com.jomar.chat.common.IService;
import br.com.jomar.chat.common.Topico;
import br.com.jomar.chat.common.Usuario;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jomar.cardoso
 */
public abstract class Client {
    
    private IService service;
    private Usuario usuario;
    
    public Client(IService service, Usuario usuario) {
        this.service = service;
        this.usuario = usuario;
    }
    
    public void login(String nome) {
        try {
            usuario.setNome(nome);
            if(service.login(usuario)) {
                //return "Login realizado com sucesso";
                JOptionPane.showMessageDialog(new JFrame(), "Login realizado com sucesso", "Login", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Login falhou, nome repetido", "Login", JOptionPane.ERROR_MESSAGE);
            }} catch (RemoteException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Problema de comunicação com o servidor", "Login", JOptionPane.ERROR_MESSAGE);
        }
    }    
    
    public ArrayList<Topico> buscaTopicos() {
        try {
            return this.service.buscaTopicos();
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Problema de comunicação com o servidor", "Login", JOptionPane.ERROR_MESSAGE);
        } 
        return null;
    }

    
}
