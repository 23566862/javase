package 编程三要素;

import java.io.IOException;
import java.net.*;

public class udp发送数据 {
    public static void main(String[] args) throws IOException {
        //创建发送端对象
        DatagramSocket ds =new DatagramSocket();

        //创建要发送的数据      DatagramPacket p数据包
        /*DatagramPacket(byte[] buf, int length,
        InetAddress address, int port)
        构造用于发送长度的分组的数据报包 length指定主机上到指定的端口号。*/
        byte [] bys ="hello.word.udp协议".getBytes();
        DatagramPacket dp =new DatagramPacket(bys,bys.length, InetAddress.getByName("192.168.1.103"),10086);

        //对象上传发送数据send(DatagramPacket p)
        //从此套接字发送数据报包。
        ds.send(dp);
        //关闭发送端
        ds.close();
    }
}
