package br.com.jomar.chat.run;

import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.jomar.chat.common.Configuration;
import br.com.jomar.chat.common.IServidor;
import br.com.jomar.chat.common.Topico;
import br.com.jomar.chat.server.Servidor;

/**
 * @author jomar.cardoso
 */
public class RunServer {

	/**
	 *
	 * @param args
	 * @throws RemoteException
	 * @throws IOException
	 */
	public static void main(String[] args) throws RemoteException, IOException {
		IServidor servidor = new RunServer().initRegister();
                System.out.println("servidor pronto");	
                
                servidor.criarTopico(new Topico("Luta"));
	}

	/**
	 * Registra a porta 1099 para o RMI e inicializa o servidor RMI
	 *
	 * @return IServidor
	 * @throws RemoteException
	 */
	public IServidor initRegister() throws RemoteException {
		LocateRegistry.createRegistry(1099);
		final Servidor servidor = new Servidor();
		try {
			IServidor remote = (IServidor) UnicastRemoteObject.exportObject(servidor, 1099);
			Registry registry = LocateRegistry.getRegistry();
			registry.bind(Configuration.SERVICE_NAME, remote);
		} catch (AlreadyBoundException | AccessException ex) {
			Logger.getLogger(RunServer.class.getName()).log(Level.SEVERE, null, ex);
		}
		return servidor;
	}
}
