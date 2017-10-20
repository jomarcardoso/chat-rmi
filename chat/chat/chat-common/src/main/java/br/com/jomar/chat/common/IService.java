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
public interface IService {
    
    public ArrayList<Topico> buscaTopicos() throws RemoteException;
    
}
