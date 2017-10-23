/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jomar.chat.client.escritor.util;

import br.com.jomar.chat.common.Noticia;
import br.com.jomar.chat.common.Topico;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Jomar
 */
public interface IClienteEscritor {
    
    public void criarTopico(String nome) throws RemoteException; 
    
    public ArrayList<Noticia> buscaTodasNoticias();
    
    public void criarNoticia(Topico topico, String texto, String titulo) throws RemoteException;    
    
}
