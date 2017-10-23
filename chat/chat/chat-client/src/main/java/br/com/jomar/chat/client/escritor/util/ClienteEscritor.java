package br.com.jomar.chat.client.escritor.util;

import br.com.jomar.chat.client.Cliente;
import br.com.jomar.chat.client.leitor.util.ClienteLeitor;
import br.com.jomar.chat.client.leitor.util.LeitorServer;
import br.com.jomar.chat.common.IServiceEscritor;
import br.com.jomar.chat.common.Noticia;
import br.com.jomar.chat.common.Topico;
import br.com.jomar.chat.common.Usuario;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author jomar.cardoso
 */
public class ClienteEscritor extends Cliente implements IClienteEscritor {

    public ClienteEscritor(IServiceEscritor service, Usuario usuario) {
        super(service, usuario);
    }

    @Override
    public void criarTopico(String nome) {
        Topico topico = new Topico(nome);
        try {
            if (this.getService().criarTopico(topico)) {
                JOptionPane.showMessageDialog(new JFrame(), "Topico criado com sucesso", "Topico", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Novo Topico falhou, nome repetido", "Topico", JOptionPane.ERROR_MESSAGE);
            }
        } catch (RemoteException ex) {
            erroServidor();
        }
    }

    @Override
    public void criarNoticia(Topico topico, String texto, String titulo) {
        Noticia noticia = new Noticia(texto, titulo, topico, getPegaDataAtual());
        try {
            this.getService().criarNoticia(noticia);
            JOptionPane.showMessageDialog(new JFrame(), "Noticia criada com sucesso", "Noticia", JOptionPane.INFORMATION_MESSAGE);
        } catch (RemoteException ex) {
            erroServidor();
        }
    }

    @Override
    public ArrayList<Noticia> buscaTodasNoticias() {
        try {
            return this.getService().buscaTodasNoticias();

        } catch (RemoteException ex) {
            erroServidor();
        }
        return null;
    }

    @Override
    public IServiceEscritor getService() {
        return (IServiceEscritor) this.service;
    }

    public Date getPegaDataAtual() {
        Calendar calendar = new GregorianCalendar();
        Date date = new Date();
        calendar.setTime(date);
        return calendar.getTime();
    }

    @Override
    public void abrirSocket() {
//        server = new EscritorServer(this);
//
//        Thread threadSocket = new Thread(server);
//        threadSocket.start();
        //System.out.println("Porta " + port + " aberta!");
    }
}
