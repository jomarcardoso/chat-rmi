/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jomar.chat.client.escritor.util;

import br.com.jomar.chat.common.Escritor;
import br.com.jomar.chat.common.IServiceEscritor;
import br.com.jomar.chat.common.RmiClient;
import br.com.jomar.chat.common.Topico;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author jomar.cardoso
 */
public class RunEscritor {
    
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Escritor escritor = new Escritor("Jorge");
        
        IServiceEscritor service = new RmiClient<IServiceEscritor>().getService();
        ArrayList<Topico> topicos = service.buscaTopicos();
        service.criarNoticia(topicos.get(0), "Oi eu sou Goku", "Dragonball");
    }
    
}