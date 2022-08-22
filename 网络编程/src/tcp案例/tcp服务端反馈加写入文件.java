package 网络编程.src.tcp案例;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class tcp服务端反馈加写入文件 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw1 = new BufferedWriter(new FileWriter("网络编程\\tcp.txt"));   //写入文件
        ServerSocket  ss =new ServerSocket(1234);
        Socket s = ss.accept();
        //InputStream is = s.getInputStream();
        BufferedReader br =new BufferedReader(new InputStreamReader(s.getInputStream()));
        String s1;
        while((s1 =br.readLine())!=null){
            System.out.println("数据是:"+s1);
            //控制台输出完毕把数据写入文件
            bw1.write(s1);
            bw1.newLine();
            bw1.flush();
            //服务器给出反馈
            BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bw.write("服务器接收成功！");
            bw.newLine();
            bw.flush();
        }
        bw1.close();
        ss.close();
    }
}
