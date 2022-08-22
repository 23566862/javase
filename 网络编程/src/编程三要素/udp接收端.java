package 编程三要素;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class udp接收端 {
    public static void main(String[] args) throws IOException {
        //创建接收端对象
        DatagramSocket ds =new DatagramSocket(10086);

        //创建接收对象的数据包对象
       /* DatagramPacket(byte[] buf, int length)
        构造一个 DatagramPacket用于接收长度的数据包 length 。*/
        byte[] bytes =new byte[1024];
        DatagramPacket dp =new DatagramPacket(bytes,bytes.length);

        //把数据传进接收端receive(DatagramPacket p)
        //从此套接字接收数据报包。
        ds.receive(dp);

       /* getData()
        返回数据缓冲区  返回byte[]。*/
        System.out.println("数据："+new String(dp.getData(),0,bytes.length));

    }
}
