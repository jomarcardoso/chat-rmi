/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jomar.chat.common;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Jomar
 */
public interface IServiceEscritor extends IService {
    
    public Boolean criarTopico(Topico topico) throws RemoteException;    
    
    public Boolean criarNoticia(Noticia noticia) throws RemoteException;    
    
    public ArrayList<Noticia> buscaTodasNoticias() throws RemoteException;       
    
}
