package Program1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BroadcastingClient {
    private static DatagramSocket socket = null;

    public static void main(String[] args) {

        String address = Validator.getAdress();
        String message = Validator.getMessage();
        int port = Validator.getPort();

        try {
            broadcast(message, InetAddress.getByName(address),port);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void broadcast(
            String broadcastMessage, InetAddress address, int port) throws IOException {
        socket = new DatagramSocket();
        socket.setBroadcast(true);

        byte[] buffer = broadcastMessage.getBytes();

        DatagramPacket packet
                = new DatagramPacket(buffer, buffer.length, address, port);
        socket.send(packet);
        socket.close();
    }
}