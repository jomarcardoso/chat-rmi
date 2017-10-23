package br.com.jomar.chat.server;

import br.com.jomar.chat.common.IServidor;
import br.com.jomar.chat.common.Inscricao;
import br.com.jomar.chat.common.Leitor;
import br.com.jomar.chat.common.Noticia;
import br.com.jomar.chat.common.Topico;
import br.com.jomar.chat.common.Usuario;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Implementas os métodos remotos para o escritor e o leitor
 *
 * @author Jomar
 */
public class Servidor implements IServidor {

    public Servidor() throws RemoteException {
        super();
    }

    private void enviarNoticia(Usuario usuario, Noticia noticia) throws IOException {
        try (Socket socket = new Socket(usuario.getIp(), usuario.getPorta())) {
            System.out.println("O cliente se conectou ao servidor!");
            String mensagem = noticia.getTopico().getNome() + " - " + noticia.getTitulo() + " - " + noticia.getTexto();
//            try (Scanner teclado = new Scanner(mensagem);
//                PrintStream saida = new PrintStream(cliente.getOutputStream());) {
//                saida.println(teclado.nextLine());
//                saida.close();
//            }
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            os.writeObject(noticia);
            os.close();
        }
    }

    @Override
    public Boolean criarTopico(Topico topico) throws RemoteException {        
        for (Topico l : Repositorio.getInstance().getTopicos()) {
            if (l.getNome().equals(topico.getNome())) {
                return false;
            }
        }
        Repositorio.getInstance().getTopicos().add(topico); 
        return true;
    }

    @Override
    public Boolean criarNoticia(Noticia noticia) throws RemoteException {
        Repositorio.getInstance().getNoticias().add(noticia);
        for(Inscricao i : Repositorio.getInstance().getInscricoes()) {
            if(noticia.getTopico().getNome().equals(i.getTopico().getNome())) {
                try {
                    this.enviarNoticia(i.getLeitor(), noticia);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "Usuario " + i.getLeitor().getNome() + "esta desconectado", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        return false;
    }

    @Override
    public ArrayList<Topico> buscaTopicos() throws RemoteException {
        return Repositorio.getInstance().getTopicos();
    }

    @Override
    public boolean inscrever(Inscricao inscricao) throws RemoteException {
        
        for (Inscricao i : Repositorio.getInstance().getInscricoes()) {
            if (i.getLeitor().equals(inscricao.getLeitor()) && i.getTopico().equals(inscricao.getTopico())) {
                return false;
            }
        }
        Repositorio.getInstance().getInscricoes().add(inscricao);
        return true;
    }

    @Override
    public Noticia buscaUltimaNoticia(Topico topico) throws RemoteException {
        return Repositorio.getInstance().getNoticias().get(Repositorio.getInstance().getNoticias().size() - 1);
    }

    @Override
    public ArrayList<Noticia> buscaNoticiasIntervalo(Topico topico, Date inicio, Date fim) throws RemoteException {
        return Repositorio.getInstance().getNoticias();
    }

    @Override
    public Boolean login(Usuario usuario) throws RemoteException {        
        if(Leitor.class.isInstance(usuario)) {
            for (Usuario l : Repositorio.getInstance().getLeitores()) {
                if (l.getNome().equals(usuario.getNome())) {
                    return false;
                }
            }            
            Repositorio.getInstance().getLeitores().add(usuario);
        } else {
            Repositorio.getInstance().getEscritores();      
            for (Usuario l : Repositorio.getInstance().getEscritores()) {
                if (l.getNome().equals(usuario.getNome())) {
                    return false;
                }
            }
            Repositorio.getInstance().getEscritores().add(usuario);
        }
        
        return true;
    }

    @Override
    public ArrayList<Noticia> buscaTodasNoticias() throws RemoteException {
        return Repositorio.getInstance().getNoticias();
    }
}
