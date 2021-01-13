package Program1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class MulticastReceiver extends Thread {
    protected MulticastSocket socket = null;
    protected byte[] buf = new byte[256];
    int port;
    String adress;

    MulticastReceiver(int port, String adress){
        this.port = port;
        this.adress =adress;
    }

    public void run() {
        System.out.println("Start listening on: "+adress+":"+port);
        try {
            socket = new MulticastSocket(port);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        InetAddress group = null;
        try {
            group = InetAddress.getByName(adress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            socket.joinGroup(group);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        while (true) {
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            String received = new String(
                    packet.getData(), 0, packet.getLength());
            System.out.println("Otrzymany od klienta: "+received + packet.getAddress().toString()+":"+packet.getPort() );
            if ("end".equals(received)) {
                break;
            }
        }
        try {
            socket.leaveGroup(group);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        socket.close();
    }
}