package 编程三要素;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class udp案例接收端 {
    public static void main(String[] args) throws IOException {
        //发送端输入886结束，接收端采用死循环接收
        DatagramSocket dc =new DatagramSocket(1024);
        while(true){
            byte[] by =new byte[1024];
            DatagramPacket dp =new DatagramPacket(by,by.length);
            dc.receive(dp);
            String s1 =new String(dp.getData(),0,by.length);
            System.out.println(s1);

        }
    }
}
