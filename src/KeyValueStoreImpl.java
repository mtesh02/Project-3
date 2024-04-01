
//Copyright(c))2023, Munywoki D. Kiteme < munywoki1735 at gmail dot com >
//All rights reserved.

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class KeyValueStoreImpl extends UnicastRemoteObject implements KeyValueStore {
    private HashMap<String, String> keyValueMap;

    public KeyValueStoreImpl() throws RemoteException {
        super();
        keyValueMap = new HashMap<>();
    }

    @Override
    public String get(String key) throws RemoteException {
        // Implementation for GET operation
        if (keyValueMap.containsKey(key)) {
            return keyValueMap.get(key);
        } else {
            return "Key not found";
        }
    }

    @Override
    public void put(String key, String value) throws RemoteException {
        // Implementation for PUT operation
        keyValueMap.put(key, value);
        System.out.println("Key-Value pair stored: " + key + " - " + value);
    }

    @Override
    public void delete(String key) throws RemoteException {
        // Implementation for DELETE operation
        if (keyValueMap.containsKey(key)) {
            keyValueMap.remove(key);
            System.out.println("Key removed: " + key);
        } else {
            System.out.println("Key not found for deletion");
        }
    }
}
