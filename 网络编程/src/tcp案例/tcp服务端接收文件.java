package 网络编程.src.tcp案例;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class tcp服务端接收文件 {
    public static void main(String[] args)throws IOException {
        BufferedOutputStream bos =new BufferedOutputStream(new FileOutputStream("网络编程\\jpg.png"));//写入文件地址
        ServerSocket ss =new ServerSocket(1045);//服务端端链接
        Socket s = ss.accept();
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));//给出客户端反馈
        InputStream is = s.getInputStream();
        byte []by =new byte[10000];
        int lenth;
        //读取写入
        while((lenth =is.read(by))!=-1){
            String shuju =new String(by,0,lenth);
           /* if(shuju.equals("break")){
                break;
            }*/
            System.out.println(new String(by,0,lenth));
            bos.write(by);
        }
        //给出反馈
        bw.write("数据接收成功！");
        bw.newLine();
        bw.flush();


        s.close();
        bos.close();
    }
}
