
//Copyright(c))2023, Munywoki D. Kiteme < munywoki1735 at gmail dot com >
//All rights reserved.

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface KeyValueStore extends Remote {
    String get(String key) throws RemoteException;
    void put(String key, String value) throws RemoteException;
    void delete(String key) throws RemoteException;
}
