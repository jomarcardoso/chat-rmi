package br.com.jomar.chat.client.leitor.util;

import br.com.jomar.chat.client.ClienteServer;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jomar
 */
public class LeitorServer extends ClienteServer implements Runnable {
    
     public LeitorServer() throws IOException {
        super();
    }

    public LeitorServer(int port) throws IOException {
        super(port);
    }

    public LeitorServer(ClienteLeitor cliente) throws IOException {
        super(cliente);        
    }   
    
    @Override
    public ClienteLeitor getCliente() {
        return (ClienteLeitor) this.cliente;
    }
    
}
