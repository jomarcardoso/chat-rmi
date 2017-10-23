/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jomar.chat.client.leitor.util;

import br.com.jomar.chat.common.Leitor;
import br.com.jomar.chat.common.Noticia;
import br.com.jomar.chat.common.Topico;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jomar
 */
public interface IClienteLeitor {
    
    void inscrever(Leitor leitor, Topico topico);

    Noticia buscaUltimaNoticia(Topico topico);
    
    public ArrayList<Noticia> buscaNoticiasIntervaloData(Topico topico, Date inicio, Date fim);
    
}
