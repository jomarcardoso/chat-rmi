package br.com.jomar.chat.common;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Jomar
 */
public interface IServiceLeitor extends IService {

    boolean inscrever(Inscricao inscricao) throws RemoteException;

    Noticia buscaUltimaNoticia(Topico topico) throws RemoteException;
    
    ArrayList<Noticia> buscaNoticiasTopico(Topico topico) throws RemoteException;    

    ArrayList<Noticia> buscaNoticiasIntervalo(Topico topico, Date inicio, Date fim) throws RemoteException;    

}
