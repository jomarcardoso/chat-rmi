package br.com.jomar.chat.client.leitor.util;

import br.com.jomar.chat.client.Client;
import br.com.jomar.chat.common.IService;
import br.com.jomar.chat.common.IServiceLeitor;
import br.com.jomar.chat.common.Leitor;
import br.com.jomar.chat.common.RmiClient;
import br.com.jomar.chat.common.Topico;
import br.com.jomar.chat.common.Usuario;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author jomar.cardoso
 */
public class LeitorClient extends Client {

    public LeitorClient(IService service, Usuario usuario) {
        super(service, usuario);
    }



}
