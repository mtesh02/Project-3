
//Copyright(c))2023, Munywoki D. Kiteme < munywoki1735 at gmail dot com >
//All rights reserved.

package Client;
import java.io.*;
import java.net.*;

public class TCPClient {
    private static final int TIMEOUT = 5000; // Timeout in milliseconds

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java TCPClient <hostname/IP> <port>");
            return;
        }

        String hostname = args[0];
        int port = Integer.parseInt(args[1]);

        try (
            Socket socket = new Socket();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            socket.connect(new InetSocketAddress(hostname, port), TIMEOUT);
            socket.setSoTimeout(TIMEOUT); // Set timeout for socket operations

            // Example usage: PUT key value
            sendRequest(out, "PUT key value");
            String response = receiveResponse(in);
            System.out.println("Server response: " + response);

            // Example usage: GET key
            sendRequest(out, "GET key");
            response = receiveResponse(in);
            System.out.println("Server response: " + response);

            // Example usage: DELETE key
            sendRequest(out, "DELETE key");
            response = receiveResponse(in);
            System.out.println("Server response: " + response);
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + hostname);
        } catch (SocketTimeoutException e) {
            System.err.println("Timeout occurred while communicating with the server.");
        } catch (IOException e) {
            System.err.println("Error in communication with the server: " + e.getMessage());
        }
    }

    private static void sendRequest(PrintWriter out, String request) {
        out.println(request);
    }

    private static String receiveResponse(BufferedReader in) throws IOException {
        return in.readLine();
    }
}
