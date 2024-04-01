
//Copyright(c))2023, Munywoki D. Kiteme < munywoki1735 at gmail dot com >
//All rights reserved.

package Client;
import java.io.*;
import java.net.*;

public class Client {
    private static final int TIMEOUT = 5000; // Timeout in milliseconds

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java Client <hostname/IP> <port> <protocol>");
            return;
        }

        String hostname = args[0];
        int port = Integer.parseInt(args[1]);
        String protocol = args[2];

        try {
            InetAddress serverAddress = InetAddress.getByName(hostname);
            Socket socket = new Socket(serverAddress, port);
            socket.setSoTimeout(TIMEOUT); // Set timeout for socket operations

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Example usage: PUT key value
            out.println("PUT key value");
            String response = in.readLine();
            System.out.println("Server response: " + response);

            // Example usage: GET key
            out.println("GET key");
            response = in.readLine();
            System.out.println("Server response: " + response);

            // Example usage: DELETE key
            out.println("DELETE key");
            response = in.readLine();
            System.out.println("Server response: " + response);

            // Close resources
            out.close();
            in.close();
            socket.close();
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + hostname);
        } catch (SocketTimeoutException e) {
            System.err.println("Timeout occurred while communicating with the server.");
        } catch (IOException e) {
            System.err.println("Error in communication with the server: " + e.getMessage());
        }
    }
}
