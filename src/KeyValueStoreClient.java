
//Copyright(c))2023, Munywoki D. Kiteme < munywoki1735 at gmail dot com >
//All rights reserved.

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class KeyValueStoreClient {
    private static final String[] SERVERS = {"Server1", "Server2", "Server3", "Server4", "Server5"};

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java KeyValueStoreClient <key> <value/delete> <operation>");
            return;
        }

        String key = args[0];
        String valueOrDelete = args[1];
        String operation = args[2];

        try {
            for (String serverName : SERVERS) {
                Registry registry = LocateRegistry.getRegistry(serverName);
                KeyValueStore stub = (KeyValueStore) registry.lookup("KeyValueStore");

                if ("PUT".equalsIgnoreCase(operation)) {
                    stub.put(key, valueOrDelete);
                    System.out.println("PUT operation successful on server: " + serverName);
                } else if ("GET".equalsIgnoreCase(operation)) {
                    String value = stub.get(key);
                    System.out.println("GET operation returned value: " + value + " from server: " + serverName);
                    break; // Stop after getting consistent data from any replica
                } else if ("DELETE".equalsIgnoreCase(operation)) {
                    stub.delete(key);
                    System.out.println("DELETE operation successful on server: " + serverName);
                } else {
                    System.out.println("Invalid operation");
                }
            }
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
