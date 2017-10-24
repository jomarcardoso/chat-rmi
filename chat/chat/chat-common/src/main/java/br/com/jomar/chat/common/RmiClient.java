package br.com.jomar.chat.common;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author jomar.cardoso
 * @param <T>
 */
public class RmiClient<T> {

    public T getService() throws RemoteException, NotBoundException {
        return getService(Configuration.SERVICE_HOST);
    }

    public T getService(String host) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(host == null ? Configuration.SERVICE_HOST : host);
        return (T) registry.lookup(Configuration.SERVICE_NAME);
    }
}
