package br.com.jomar.chat.client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jomar
 */
class LeitorServer extends ServerSocket implements Runnable {
    
    
    public LeitorServer() throws IOException {
        super();
    }

    LeitorServer(int i) throws IOException {
        super(i);
    }

    @Override
    public void run() {
        while(true) {       
            Socket cliente;
            try {
                cliente = this.accept();
                System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
                Scanner s = new Scanner(cliente.getInputStream());
                while (s.hasNextLine()) {
                   System.out.println(s.nextLine());
                }
                s.close();    
                cliente.close();  
            } catch (IOException ex) {
                Logger.getLogger(LeitorServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
