/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jomar.chat.client;

import br.com.jomar.chat.client.escritor.util.ClienteEscritor;
import br.com.jomar.chat.client.leitor.util.ClienteLeitor;
import br.com.jomar.chat.common.IMensagem;
import br.com.jomar.chat.common.Noticia;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jomar
 */
public class ClienteServer extends ServerSocket implements Runnable {
    
    protected Cliente cliente;
    protected Socket socket;
    
 public ClienteServer() throws IOException {
        super();
    }

    public ClienteServer(int port) throws IOException {
        super(port);
    }

    public ClienteServer(ClienteLeitor cliente) throws IOException {
        super(cliente.getUsuario().getPorta());
        this.cliente = cliente;
    }
    
    public ClienteServer(ClienteEscritor cliente) throws IOException {
        super(cliente.getUsuario().getPorta());
        this.cliente = cliente;
    }

    @Override
    public void run() {
        JOptionPane.showMessageDialog(new JFrame(), "Servidor socket bombando", "Socket", JOptionPane.INFORMATION_MESSAGE);
        while(true) {       
            
            try {                
                socket = this.accept();
                System.out.println("Nova conexão com o cliente " + socket.getInetAddress().getHostAddress());
                ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
                try {
                    IMensagem mensagem = (IMensagem) is.readObject();
                    this.getCliente().lerMensagem(mensagem);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ClienteServer.class.getName()).log(Level.SEVERE, null, ex);
                }          
                is.close();
                socket.close();  
            } catch (IOException ex) {
                Cliente.erroServidor();
            }
        }
    }
    
    public void fecharSocket() {
        try {
            System.out.println("Fechou fechou fechou o socket");
            socket.close();
        } catch (IOException ex) {
            Cliente.erroServidor();
        }
         
    }
    
    public static InetAddress getLocalHostLANAddress() throws UnknownHostException {
        try {
            InetAddress candidateAddress = null;
            // Iterate all NICs (network interface cards)...
            for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements();) {
                NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
                // Iterate all IP addresses assigned to each card...
                for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements();) {
                    InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
                    if (!inetAddr.isLoopbackAddress()) {

                        if (inetAddr.isSiteLocalAddress()) {
                            // Found non-loopback site-local address. Return it immediately...
                            return inetAddr;
                        }
                        else if (candidateAddress == null) {
                            // Found non-loopback address, but not necessarily site-local.
                            // Store it as a candidate to be returned if site-local address is not subsequently found...
                            candidateAddress = inetAddr;
                            // Note that we don't repeatedly assign non-loopback non-site-local addresses as candidates,
                            // only the first. For subsequent iterations, candidate will be non-null.
                        }
                    }
                }
            }
            if (candidateAddress != null) {
                // We did not find a site-local address, but we found some other non-loopback address.
                // Server might have a non-site-local address assigned to its NIC (or it might be running
                // IPv6 which deprecates the "site-local" concept).
                // Return this non-loopback candidate address...
                return candidateAddress;
            }
            // At this point, we did not find a non-loopback address.
            // Fall back to returning whatever InetAddress.getLocalHost() returns...
            InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
            if (jdkSuppliedAddress == null) {
                throw new UnknownHostException("The JDK InetAddress.getLocalHost() method unexpectedly returned null.");
            }
            return jdkSuppliedAddress;
        }
        catch (Exception e) {
            UnknownHostException unknownHostException = new UnknownHostException("Failed to determine LAN address: " + e);
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setClient(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
