package br.com.jomar.chat.client.leitor.util;

import br.com.jomar.chat.client.Cliente;
import br.com.jomar.chat.common.IService;
import br.com.jomar.chat.common.IServiceLeitor;
import br.com.jomar.chat.common.Inscricao;
import br.com.jomar.chat.common.Leitor;
import br.com.jomar.chat.common.Noticia;
import br.com.jomar.chat.common.Topico;
import br.com.jomar.chat.common.Usuario;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author jomar.cardoso
 */
public class ClienteLeitor extends Cliente implements IClienteLeitor {

    public ClienteLeitor(IService service, Usuario usuario) {
        super(service, usuario);
    }

    @Override
    public IServiceLeitor getService() {
        return (IServiceLeitor) this.service;
    }

    @Override
    public void inscrever(Leitor leitor, Topico topico) {
        Inscricao inscricao = new Inscricao(leitor, topico);
        try {
            if(this.getService().inscrever(inscricao)) {
                JOptionPane.showMessageDialog(new JFrame(), "Inscrito criado com sucesso", "Topico", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Voce ja esta inscrito neste topico!", "Topico", JOptionPane.ERROR_MESSAGE);
            }
        } catch (RemoteException ex) {
            erroServidor();
        }
    }

    @Override
    public Noticia buscaUltimaNoticia(Topico topico) {
        try {
            return this.getService().buscaUltimaNoticia(topico);
        } catch (RemoteException ex) {
            erroServidor();
        }
        return null;
    }

    @Override
    public ArrayList<Noticia> buscaNoticiasIntervaloData(Topico topico, Date inicio, Date fim) {
        try {
            return this.getService().buscaNoticiasIntervalo(topico, inicio, fim);
        } catch (RemoteException ex) {
            erroServidor();
        }
        return null;
    }

    @Override
    public void abrirSocket() throws IOException {

            server = new LeitorServer(this);
        
        Thread threadSocket = new Thread(server);
        threadSocket.start();
    }

}
