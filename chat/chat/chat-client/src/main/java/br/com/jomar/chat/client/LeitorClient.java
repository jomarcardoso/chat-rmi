package br.com.jomar.chat.client;

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
public class LeitorClient {

    public static void main(String[] args) throws RemoteException, IOException, NotBoundException {

        IServiceLeitor service = new RmiClient<IServiceLeitor>().getService();
        
        final String ip = LeitorServer.getLocalHostLANAddress().getHostAddress();
        final int port = 12399;        
        final String name = "Jorge";

        
        final LeitorServer server = new LeitorServer(port);
        Thread threadSocket = new Thread(server);
        threadSocket.start();
        System.out.println("Porta " + port + " aberta!");

        Leitor leitor = new Leitor(ip, port, name);
        String status = leitor.login(service);
        System.out.println(status);
        

//        ArrayList<Topico> topicos = service.buscaTopicos();
//        service.inscrever(leitor, topicos.get(0));
    }
    
    
    
    
}
