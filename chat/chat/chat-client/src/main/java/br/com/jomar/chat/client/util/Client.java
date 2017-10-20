/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jomar.chat.client.util;

import br.com.jomar.chat.common.IService;
import br.com.jomar.chat.common.Usuario;
import br.com.jomar.chat.common.IServiceLeitor;
import br.com.jomar.chat.common.Leitor;
import java.rmi.RemoteException;

/**
 *
 * @author jomar.cardoso
 */
public class Client {
    
    protected IService service;
    protected Usuario cliente;
    
    public Client(IService service, Usuario cliente) {
        this.service = service;
        this.cliente = cliente;
    }
    
    public String login(String nome, IServiceLeitor service2) {
        try {
            this.cliente.setNome(nome);
            if(service2.login(this.cliente)) {                
                return "Login realizado com sucesso";
            } else {
                return "Falha no login, nome repetido";
            }} catch (RemoteException ex) {
            //Logger.getLogger(Leitor.class.getName()).log(Level.SEVERE, null, ex);
            return "Falha de conexão com o servidor";
        }
    }
    
}
