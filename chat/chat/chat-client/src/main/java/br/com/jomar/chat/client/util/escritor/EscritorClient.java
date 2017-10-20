package br.com.jomar.chat.client.util.escritor;

import br.com.jomar.chat.client.util.Client;
import br.com.jomar.chat.common.Usuario;
import br.com.jomar.chat.common.Escritor;
import br.com.jomar.chat.common.IService;
import br.com.jomar.chat.common.IServiceEscritor;
import br.com.jomar.chat.common.IServiceLeitor;
import br.com.jomar.chat.common.RmiClient;
import br.com.jomar.chat.common.Topico;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author jomar.cardoso
 */
public class EscritorClient extends Client {
    
    public EscritorClient(IService service, Usuario cliente) {
        super(service, cliente);
    }
    

    
}
