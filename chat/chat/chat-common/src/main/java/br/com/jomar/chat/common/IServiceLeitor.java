package br.com.jomar.chat.common;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Jomar
 */
public interface IServiceLeitor extends IService {

    boolean inscrever(Leitor leitor, Topico topico) throws RemoteException;

    Noticia buscaUltimaNoticia(Topico topico) throws RemoteException;

    ArrayList<Noticia> buscaNoticiasIntervalo(Topico topico, Date de, Date ate) throws RemoteException;    

}
