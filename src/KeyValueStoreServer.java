
//Copyright(c))2023, Munywoki D. Kiteme < munywoki1735 at gmail dot com >
//All rights reserved.

import java.util.HashMap;
import java.util.Map;

public class KeyValueStoreServer {
    private Map<String, String> keyValueStore;

    public KeyValueStoreServer() {
        this.keyValueStore = new HashMap<>();
    }

    public String get(String key) {
        return keyValueStore.get(key);
    }

    public void put(String key, String value) {
        keyValueStore.put(key, value);
    }

    public void delete(String key) {
        keyValueStore.remove(key);
    }

    public static void main(String[] args) {
        // Instantiate multiple server instances
        KeyValueStoreServer server1 = new KeyValueStoreServer();
        KeyValueStoreServer server2 = new KeyValueStoreServer();
        KeyValueStoreServer server3 = new KeyValueStoreServer();
        KeyValueStoreServer server4 = new KeyValueStoreServer();
        KeyValueStoreServer server5 = new KeyValueStoreServer();

        // Start each server instance on a separate thread or process
        startServer(server1);
        startServer(server2);
        startServer(server3);
        startServer(server4);
        startServer(server5);
    }

    private static void startServer(KeyValueStoreServer server) {
        // Start the server on a separate thread or process
        Thread serverThread = new Thread(() -> {
            // Code to start the server and handle client requests
            System.out.println("Server started: " + server);
        });
        serverThread.start();
    }
}
