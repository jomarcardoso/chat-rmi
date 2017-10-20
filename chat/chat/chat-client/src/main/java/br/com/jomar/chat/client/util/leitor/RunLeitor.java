package br.com.jomar.chat.client.util.leitor;

import br.com.jomar.chat.client.view.TelaLeitor;
import br.com.jomar.chat.common.IServiceLeitor;
import br.com.jomar.chat.common.Leitor;
import br.com.jomar.chat.common.RmiClient;
import br.com.jomar.chat.common.Topico;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author jomar.cardoso
 */
public class RunLeitor {
    
      
    
//    public boolean inscrever(IServiceLeitor service) {
//        
//    }

    public static void main(String[] args) throws RemoteException, IOException, NotBoundException {

        IServiceLeitor service = new RmiClient<IServiceLeitor>().getService();
        
        //dados para criar o leitor e o leitorServer
        final String ip = LeitorServer.getLocalHostLANAddress().getHostAddress();
        final int port = 12399;        
        final String name = "Joses";

        //iniciando servidor socket
        final LeitorServer server = new LeitorServer(port);
        Thread threadSocket = new Thread(server);
        threadSocket.start();
        System.out.println("Porta " + port + " aberta!");

        Leitor leitor = new Leitor(ip, port);
        LeitorClient leitorClient = new LeitorClient(service, leitor);
        
        String status = leitorClient.login(name, service);
        System.out.println(status);
        
        new TelaLeitor();
        
    }

}
