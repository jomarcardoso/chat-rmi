package br.com.jomar.chat.client.escritor.util;

import br.com.jomar.chat.client.Cliente;
import br.com.jomar.chat.client.leitor.util.*;
import br.com.jomar.chat.client.ClienteServer;
import java.io.IOException;

/**
 * 
 * @author Jomar
 */
class EscritorServer extends ClienteServer implements Runnable {
    
     public EscritorServer() throws IOException {
        super();
    }

    public EscritorServer(int port) throws IOException {
        super(port);
    }

    public EscritorServer(ClienteEscritor cliente) throws IOException {
        super(cliente);        
    }   
    
    @Override
    public ClienteEscritor getCliente() {
        return (ClienteEscritor) this.cliente;
    }
    
}
