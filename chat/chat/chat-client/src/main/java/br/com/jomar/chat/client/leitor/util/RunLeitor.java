/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jomar.chat.client.leitor.util;

import br.com.jomar.chat.common.IServiceLeitor;
import br.com.jomar.chat.common.Leitor;
import br.com.jomar.chat.common.RmiClient;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author jomar.cardoso
 */
public class RunLeitor {
    
    public static void main(String[] args) throws RemoteException, IOException, NotBoundException {

        IServiceLeitor service = new RmiClient<IServiceLeitor>().getService();
        
        final String ip = LeitorServer.getLocalHostLANAddress().getHostAddress();
        final int port = 12399;        
        final String name = "Jorge";

        
        final LeitorServer server = new LeitorServer(port);
        Thread threadSocket = new Thread(server);
        threadSocket.start();
        System.out.println("Porta " + port + " aberta!");

        Leitor leitor = new Leitor(ip, port);
        ClienteLeitor leitorClient = new ClienteLeitor(service, leitor);
        leitorClient.login(name);
        //System.out.println(status);
        
    }
    
}
