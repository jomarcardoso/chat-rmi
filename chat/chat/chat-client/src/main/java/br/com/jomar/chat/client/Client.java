/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jomar.chat.client;

import br.com.jomar.chat.common.IService;
import br.com.jomar.chat.common.IServiceLeitor;
import br.com.jomar.chat.common.Usuario;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jomar.cardoso
 */
public class Client {
    
    private IService service;
    private Usuario usuario;
    
    public Client(IService service, Usuario usuario) {
        this.service = service;
        this.usuario = usuario;
    }
    
    public String login(String nome) {
        try {
            usuario.setNome(nome);
            if(service.login(usuario)) {
                return "Login realizado com sucesso";
            } else {
                return "Login falhou, nome repetido";
            }} catch (RemoteException ex) {
            return "erro de conexão";
        }
    }    
    
}
