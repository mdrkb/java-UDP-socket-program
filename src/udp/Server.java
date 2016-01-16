package udp;

import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception{
        DatagramSocket serversocket = new DatagramSocket(1234);
        byte[] senddata = new byte[1024];
        byte[] receivedata = new byte[1024];
         
        while(true){
            DatagramPacket inFromClient = new DatagramPacket(receivedata, receivedata.length);
            serversocket.receive(inFromClient);
            String input = new String(inFromClient.getData());
            InetAddress ip = inFromClient.getAddress();
            int port = inFromClient.getPort();
            System.out.println("Server input: "+input);
            
            String output = "";
            
            char[] ch = input.toCharArray();
            int j=0;
            while(ch[j]!='\0'){
                j++;
            }
            System.out.println("Length: "+j);
            
            for(int i=0; i<ch.length; i++){
                output += ((char)(((int)ch[i])+1));
            }
            
            senddata = output.getBytes();
            System.out.println("Server output: "+output);
            DatagramPacket outToClient = new DatagramPacket(senddata, senddata.length, ip, port);
            serversocket.send(outToClient);
        }
    }
}
