package br.com.jomar.chat.client;

import br.com.jomar.chat.common.IServiceEscritor;
import br.com.jomar.chat.common.RmiClient;
import br.com.jomar.chat.common.Topico;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author jomar.cardoso
 */
public class EscritoClient {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Escritor escritor = new Escritor("Jorge");
        
        IServiceEscritor service = new RmiClient<IServiceEscritor>().getService();
        ArrayList<Topico> topicos = service.buscaTopicos();
        service.criarNoticia(topicos.get(0), "Oi eu sou Goku", "Dragonball");
    }

}
