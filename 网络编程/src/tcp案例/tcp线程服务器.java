package 网络编程.src.tcp案例;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class tcp线程服务器 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4560);

        while (true) {
            Socket s = ss.accept();
            new Thread(new tcp案例.run(s)).start();
        }
    }
}
