/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jomar.chat.client;

import br.com.jomar.chat.client.leitor.util.ClienteLeitor;
import br.com.jomar.chat.client.leitor.util.LeitorServer;
import br.com.jomar.chat.common.IMensagem;
import br.com.jomar.chat.common.IService;
import br.com.jomar.chat.common.Noticia;
import br.com.jomar.chat.common.Topico;
import br.com.jomar.chat.common.Usuario;
import java.io.IOException;
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
public abstract class Cliente implements ICliente {
    
    protected IService service;
    protected Usuario usuario;
    protected ClienteServer server;
    
    public Cliente(IService service, Usuario usuario) {
        this.service = service;
        this.usuario = usuario;
    }
    
    @Override
    public Boolean login(String nome) {
        try {
            usuario.setNome(nome);
            if(service.login(usuario)) {
                abrirSocket();
                JOptionPane.showMessageDialog(new JFrame(), "Login realizado com sucesso", "Login", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Login falhou, nome repetido", "Login", JOptionPane.ERROR_MESSAGE);
                return false;
            }} catch (RemoteException ex) {
            erroServidor();
            return false;
        }
    }    
    
    @Override
    public ArrayList<Topico> buscaTopicos() {
        try {
            return this.service.buscaTopicos();
        } catch (RemoteException ex) {
            erroServidor();
        } 
        return null;
    }
    
    @Override
    public void lerMensagem(IMensagem mensagem) {
        if(Topico.class.isInstance(mensagem)) {
            Topico topico = (Topico) mensagem;
            System.out.println(topico.getNome());
        } else if(Noticia.class.isInstance(mensagem)) {
            Noticia noticia = (Noticia) mensagem;
            System.out.println(noticia.getTexto());
        }
    }
    
    public static void erroServidor() {
        JOptionPane.showMessageDialog(new JFrame(), "Problema de comunicação com o servidor", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public IService getService() {
        return service;
    }

    public void setService(IService service) {
        this.service = service;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }    

    public  abstract void abrirSocket();
}
