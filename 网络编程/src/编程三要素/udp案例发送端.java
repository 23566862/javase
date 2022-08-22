package 编程三要素;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class udp案例发送端 {
    public static void main(String[] args) throws IOException {
        //发送的内容从控制台输入，直到输入886结束发送
        DatagramSocket ds =new DatagramSocket();

        //控制台输入
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=bf.readLine())!=null){
                if(s.equals("886")){
                    break;
                }
                byte[] by =s.getBytes();
                DatagramPacket dp =new DatagramPacket(by,by.length, InetAddress.getByName("192.168.1.102"),1024);
                ds.send(dp);

        }
        ds.close();

    }
}
