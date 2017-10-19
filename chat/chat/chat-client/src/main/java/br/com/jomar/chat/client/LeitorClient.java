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

        final int port = 12399;
        final String name = "Jomar";

        final LeitorServer server = new LeitorServer(port);
        Thread threadSocket = new Thread(server);
        threadSocket.start();
        System.out.println("Porta 12399 aberta!");

        Leitor leitor = new Leitor(port, name);
        service.login(leitor);

        System.out.println(name + " - " + port);

        ArrayList<Topico> topicos = service.buscaTopicos();
        System.out.println("vou me inscrever no topico: " + topicos.get(0).getNome());
        service.inscrever(leitor, topicos.get(0));
    }
}
