/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jomar.chat.client.escritor.util;

import br.com.jomar.chat.client.escritor.view.TelaEscritor;
import br.com.jomar.chat.common.Escritor;
import br.com.jomar.chat.common.IServiceEscritor;
import br.com.jomar.chat.common.RmiClient;
import br.com.jomar.chat.common.Topico;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author jomar.cardoso
 */
public class RunEscritor {
    
    public static void main(String[] args) throws RemoteException, NotBoundException {
        
        // RMI
        IServiceEscritor service = new RmiClient<IServiceEscritor>().getService();
        
        // Cliente
        final String ip = EscritorServer.getLocalHostLANAddress().getHostAddress();
        final int port = 12499;   
        String name = "Jil";
        Escritor escritor = new Escritor("", port);    
        ClienteEscritor escritorClient = new ClienteEscritor(service, escritor);

        // telas
        new TelaEscritor(escritorClient);
    }
    
}
