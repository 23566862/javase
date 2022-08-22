package 编程三要素;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class tcp服务端 {
    public static void main(String[] args) throws IOException {
        //1创建服务端对象，serverSocket对象
        //2调用accept()侦听要连接到此套接字并接受它。
        //3得到字节流文件

        //1
        ServerSocket ss =new ServerSocket(1000);
        //2
        Socket s = ss.accept();
        //3
        InputStream is = s.getInputStream();
        //4
        byte [] by =new byte[1024];
        int lenth;
        while((lenth =is.read(by))!=-1){
            System.out.println("数据是:"+new String(by,0,lenth));
        }
        ss.close();
    }
}
