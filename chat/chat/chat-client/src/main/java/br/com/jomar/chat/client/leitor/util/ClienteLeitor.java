package br.com.jomar.chat.client.leitor.util;

import br.com.jomar.chat.client.Cliente;
import br.com.jomar.chat.common.IService;
import br.com.jomar.chat.common.IServiceLeitor;
import br.com.jomar.chat.common.Usuario;

/**
 * @author jomar.cardoso
 */
public class ClienteLeitor extends Cliente {

    public ClienteLeitor(IService service, Usuario usuario) {
        super(service, usuario);
    }

    @Override
    public IServiceLeitor getService() {
        return (IServiceLeitor) this.service;
    }


}
