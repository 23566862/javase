package 编程三要素;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class fasong {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new FileReader("Io\\JPG.png"));
        DatagramSocket ds = new DatagramSocket();
        StringBuffer sb =new StringBuffer();
        byte [] by =new byte[1024];
        String s;
        while ((s=br.readLine())!=null){
           sb.append(s).append('\n');
        }
       by =sb.toString().getBytes();
        DatagramPacket dp =new DatagramPacket(by,by.length, InetAddress.getByName("192.168.1.104"),10086);
        ds.send(dp);
        ds.close();


    }
}
