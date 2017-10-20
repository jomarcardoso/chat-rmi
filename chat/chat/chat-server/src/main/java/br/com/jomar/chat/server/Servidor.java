package br.com.jomar.chat.server;

import br.com.jomar.chat.common.Usuario;
import br.com.jomar.chat.common.IServidor;
import br.com.jomar.chat.common.Inscricao;
import br.com.jomar.chat.common.Leitor;
import br.com.jomar.chat.common.Noticia;
import br.com.jomar.chat.common.Topico;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementas os métodos remotos para o escritor e o leitor
 *
 * @author Jomar
 */
public class Servidor implements IServidor {

    public Servidor() throws RemoteException {
        super();
    }

    public void enviarNoticia(Noticia noticia) throws IOException {
        final ArrayList<Inscricao> inscricoes = Repositorio.getInstance().getInscricoes();
        for (Inscricao inscriacao : inscricoes) {
            final String nomeInscricao = inscriacao.getTopico().getNome();
            System.out.println(nomeInscricao);
            if (nomeInscricao.equals(noticia.getTopico().getNome())) {
                send(inscriacao.getLeitor(), noticia);
            }
        }
    }

    private void send(Leitor leitor, Noticia noticia) throws IOException {

        try (Socket cliente = new Socket(leitor.getIp(), leitor.getPorta())) {
            System.out.println("O cliente se conectou ao servidor!");
            String mensagem = noticia.getTopico().getNome() + " - " + noticia.getTitulo() + " - " + noticia.getTexto();
            try (Scanner teclado = new Scanner(mensagem);
                    PrintStream saida = new PrintStream(cliente.getOutputStream());) {
                saida.println(teclado.nextLine());
                saida.close();
            }
        }
    }

    @Override
    public ArrayList<Topico> criarTopico(String nome) throws RemoteException {
        Topico topico = new Topico(nome);
        Repositorio.getInstance().getTopicos().add(topico);
        return Repositorio.getInstance().getTopicos();
    }

    @Override
    public Noticia criarNoticia(Topico topico, String texto, String titulo) throws RemoteException {
        Noticia noticia = new Noticia(texto, titulo, topico);
        Repositorio.getInstance().getNoticias().add(noticia);
        try {
            this.enviarNoticia(noticia);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return noticia;
    }

    @Override
    public ArrayList<Topico> buscaTopicos() throws RemoteException {
        return Repositorio.getInstance().getTopicos();
    }

    @Override
    public boolean inscrever(Leitor leitor, Topico topico) throws RemoteException {
        
        for (Inscricao i : Repositorio.getInstance().getInscricoes()) {
            if (i.getLeitor().equals(leitor) && i.getTopico().equals(topico)) {
                return false;
            }
        }
        Inscricao inscricao = new Inscricao(leitor, topico);
        Repositorio.getInstance().getInscricoes().add(inscricao);
        System.out.println("Inscrito em topico");
        return true;
    }

    @Override
    public Noticia buscaUltimaNoticia(Topico topico) throws RemoteException {
        return Repositorio.getInstance().getNoticias().get(Repositorio.getInstance().getNoticias().size() - 1);
    }

    @Override
    public ArrayList<Noticia> buscaNoticiasIntervalo(Topico topico) throws RemoteException {
        return Repositorio.getINSTANCE().getNoticias(topico);
    }

    @Override
    public Boolean login(Usuario cliente) throws RemoteException {        
        
        if(Leitor.class.isInstance(cliente)) {
            Repositorio.getInstance().getLeitores().add(cliente);  
            for (Usuario l : Repositorio.getInstance().getLeitores()) {
                if (l.getNome().equals(cliente.getNome())) {
                    return false;
                }
            }
        } else {
            Repositorio.getInstance().getEscritores().add(cliente);      
            for (Usuario l : Repositorio.getInstance().getEscritores()) {
                if (l.getNome().equals(cliente.getNome())) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
