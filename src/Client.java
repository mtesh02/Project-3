
//Copyright(c))2023, Munywoki D. Kiteme < munywoki1735 at gmail dot com >
//All rights reserved.

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Client <hostname/IP>");
            return;
        }

        String hostname = args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(hostname);
            KeyValueStore stub = (KeyValueStore) registry.lookup("KeyValueStore");

            // Example usage: stub.put("key1", "value1");
            stub.put("key1", "value1");

            // Example usage: String value = stub.get("key1");
            String value = stub.get("key1");
            System.out.println("GET response: " + value);

            // Example usage: stub.delete("key1");
            stub.delete("key1");

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
