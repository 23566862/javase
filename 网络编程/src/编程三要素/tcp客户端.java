package 编程三要素;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class tcp客户端 {
    public static void main(String[] args) throws IOException {
        //创建socket对象,传ip地址加端口号
        //调用getoutpustream方法写入数据
        //写入数据
        //1
        Socket s = new Socket(InetAddress.getByName("192.168.1.102"),1000);
        //2
        OutputStream os = s.getOutputStream();
        //3
        os.write("tcp协议客户端".getBytes());
        s.close();
    }
}
