package udp;

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception{
        InetAddress ip = InetAddress.getLocalHost();
        DatagramSocket clientsocket = new DatagramSocket();
        byte[] senddata = new byte[1024];
        byte[] receivedata = new byte[1024];
        
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter text: ");
        String input = inFromUser.readLine();
        System.out.println("Client output: "+input);
        senddata = input.getBytes();
        DatagramPacket sendpacket = new DatagramPacket(senddata, senddata.length, ip, 1234);
        clientsocket.send(sendpacket);
        
        DatagramPacket receivepacket = new DatagramPacket(receivedata, receivedata.length);
        clientsocket.receive(receivepacket);
        String text = new String(receivepacket.getData());
        System.out.println("Client input: "+text);
        clientsocket.close();
    }
}
