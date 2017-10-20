/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jomar.chat.client.util.leitor;

import br.com.jomar.chat.client.util.Client;
import br.com.jomar.chat.common.IService;
import br.com.jomar.chat.common.Usuario;
import br.com.jomar.chat.common.IServiceLeitor;
import br.com.jomar.chat.common.Leitor;
import java.rmi.RemoteException;

/**
 *
 * @author jomar.cardoso
 */
public class LeitorClient extends Client {

    public LeitorClient(IService service, Usuario cliente) {
        super(service, cliente);
    }



    
}
