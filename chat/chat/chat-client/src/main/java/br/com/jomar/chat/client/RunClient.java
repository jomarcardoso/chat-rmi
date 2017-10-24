package br.com.jomar.chat.client;

import br.com.jomar.chat.client.escritor.util.RunEscritor;
import br.com.jomar.chat.client.leitor.util.RunLeitor;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author jomar.cardoso
 */
public class RunClient {

    public static void main(String[] args) throws RemoteException, IOException, NotBoundException {

        //--tipo=leitor||escritor & --host=127.0.0.1
        //System.out.println(args[1]);
        if (args.length > 1) {
            String tipo = null;
            String host = null;
            for (String param : args) {
                System.out.println(param);
                final String[] split = param.split("=");
                if ("--tipo".equals(split[0])) {
                    tipo = split[1];
                } else if ("--host".equals(split[0])) {
                    host = split[1];
                }
            }
            if (tipo == null || host == null) {
                System.exit(-1);
            }
            
            if ("leitor".equals(tipo)) {
                RunLeitor runLeitor = new RunLeitor(host);
            } else {
                RunEscritor runEscritor = new RunEscritor(host);
            }
        } else {
            String host = "10.99.5.41";
            RunEscritor runEscritor = new RunEscritor(host);
        }        

    }


}
