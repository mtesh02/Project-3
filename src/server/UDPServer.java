
//Copyright(c))2023, Munywoki D. Kiteme < munywoki1735 at gmail dot com >
//All rights reserved.

package server;
import java.io.*;
import java.net.*;

public class UDPServer {
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (DatagramSocket serverSocket = new DatagramSocket(SERVER_PORT)) {
            System.out.println("UDP Server is running on port " + SERVER_PORT);

            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                // Get client's information
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // Process received data
                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from client " + clientAddress.getHostAddress() + ":" + clientPort + ": " + receivedMessage);

                // Send response back to the client
                String responseMessage = "Message received: " + receivedMessage;
                byte[] sendData = responseMessage.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
