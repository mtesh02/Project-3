
//Copyright(c))2023, Munywoki D. Kiteme < munywoki1735 at gmail dot com >
//All rights reserved.

package server;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPHandler implements Runnable {
    private DatagramSocket socket;
    private DatagramPacket packet;

    public UDPHandler(DatagramSocket socket, DatagramPacket packet) {
        this.socket = socket;
        this.packet = packet;
    }

    @Override
    public void run() {
        try {
            // Extract data from the received packet
            byte[] data = packet.getData();
            int length = packet.getLength();
            String message = new String(data, 0, length);

            // Process the message if needed
            String response = processMessage(message);

            // Send response back to the client
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.length(),
                    packet.getAddress(), packet.getPort());
            socket.send(responsePacket);
        } catch (IOException e) {
            System.err.println("Error handling UDP request: " + e.getMessage());
        }
    }

    private String processMessage(String message) {
        // Implement your logic to process the message and generate a response
        return "Server response to '" + message + "'";
    }
}
