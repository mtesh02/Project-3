
//Copyright(c))2023, Munywoki D. Kiteme < munywoki1735 at gmail dot com >
//All rights reserved.

package Client;

import java.io.*;
import java.net.*;

public class UDPClient {
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName("localhost");

            // Sample data to send
            String message = "Hello, UDP Server!";
            byte[] sendData = message.getBytes();

            // Send data to the server
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, SERVER_PORT);
            clientSocket.send(sendPacket);

            // Log the sent message
            ClientLogger.log("Sent message to server: " + message);

            // Receive response from the server
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            // Process the received response
            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());

            // Log the received response
            ClientLogger.log("Received response from server: " + receivedMessage);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
