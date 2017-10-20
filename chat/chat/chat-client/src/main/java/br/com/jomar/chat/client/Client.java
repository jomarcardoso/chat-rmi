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

/**
 *
 * @author jomar.cardoso
 */
public class Client {
    
    private IService service;
    
    public String login(IServiceLeitor service, Usuario usuario) throws RemoteException {
       if(service.login(usuario)) {
           return "Login realizado com sucesso";           
       } else {
           return "Login falhou, nome repetido";
       }
    }    
    
}
