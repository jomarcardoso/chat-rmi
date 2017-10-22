/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jomar.chat.client;

import br.com.jomar.chat.common.IMensagem;
import br.com.jomar.chat.common.Topico;
import java.util.ArrayList;

/**
 *
 * @author Jomar
 */
interface ICliente {
    
    public void login(String nome);
    
    public ArrayList<Topico> buscaTopicos();
    
    public void lerMensagem(IMensagem mensagem);
    
}
