package 网络编程.src.tcp案例;

import java.io.*;
import java.net.Socket;

public class tcp客服端发送文件 {
    public static void main(String[] args) throws IOException {
         BufferedInputStream bis =new BufferedInputStream(new FileInputStream("Io\\JPG.png")) ;
        Socket s =new Socket("192.168.1.104",1045);//客户端链接
        OutputStream os = s.getOutputStream();
        BufferedReader br1 =new BufferedReader(new InputStreamReader(s.getInputStream()));
        byte [] by =new byte[100000];
        int length;
        //传文件给服务端
        while((length=bis.read(by))!=-1){
            os.write(by);
        }
        s.shutdownOutput();
        //给出服务端反馈
        String fangui = br1.readLine();
        System.out.println("客户端："+fangui);

        bis.close();
        s.close();

    }
}
