package br.com.jomar.chat.server;

import br.com.jomar.chat.common.Configuration;
import br.com.jomar.chat.common.IServidor;
import br.com.jomar.chat.common.Leitor;
import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jomar.cardoso
 */
public class Run {

    /**
     * @param args the command line arguments
     * @throws java.rmi.RemoteException
     */
    public static void main(String[] args) throws RemoteException, IOException {

        LocateRegistry.createRegistry(1099);

        IServidor servidor = initRegister();

        Leitor leitorJomar = new Leitor(0, "Jomar");
        Repositorio.getInstance().getLeitores().add(leitorJomar);

        Leitor leitorJean = new Leitor(0, "Jean");
        Repositorio.getInstance().getLeitores().add(leitorJean);

        Leitor leitorFernando = new Leitor(0, "Fernando");
        Repositorio.getInstance().getLeitores().add(leitorFernando);
        System.out.println("servidor pronto");

        servidor.criarTopico("Luta");
    }

    private static IServidor initRegister() throws RemoteException {
        final Servidor servidor = new Servidor();
        try {
            IServidor remote = (IServidor) UnicastRemoteObject.exportObject(servidor, 1099);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind(Configuration.SERVICE_NAME, remote);
        } catch (AlreadyBoundException | AccessException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        }
        return servidor;
    }
}
