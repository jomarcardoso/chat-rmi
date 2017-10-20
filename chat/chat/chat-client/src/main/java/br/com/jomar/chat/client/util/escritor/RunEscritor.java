package br.com.jomar.chat.client.util.escritor;

import br.com.jomar.chat.client.view.TelaEscritor;
import br.com.jomar.chat.common.Escritor;
import br.com.jomar.chat.common.IServiceEscritor;
import br.com.jomar.chat.common.IServiceLeitor;
import br.com.jomar.chat.common.RmiClient;
import br.com.jomar.chat.common.Topico;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author jomar.cardoso
 */
public class RunEscritor {
    
      
    
//    public boolean inscrever(IServiceLeitor service) {
//        
//    }

    public static void main(String[] args) throws RemoteException, IOException, NotBoundException {

        IServiceEscritor service = new RmiClient<IServiceEscritor>().getService();
        
        //dados para criar o escritor      
        final String name = "Ruana";


       //Escritor escritor = new Escritor();
       
//        EscritorClient escritorClient = new EscritorClient(service, escritor);   
        
        
        //String status = escritorClient.login(name);   
        //System.out.println(status);
        
        ArrayList<Topico> topico = service.criarTopico("Luta");
        //service.criarNoticia(topico, "Oi eu sou Goku", "Dragonball Z")
        
        new TelaEscritor();
        
    }

}
