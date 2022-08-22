package 网络编程.src.tcp案例;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class tcp客户端反馈加写入文件 {

    public static void main(String[] args) throws IOException {
        Socket s =new Socket("192.168.1.104",1234);
        System.out.println("客户端"+InetAddress.getLocalHost());
            while(true){
                System.out.println("输入你要发送的数据(0退出):");
                BufferedReader br =new BufferedReader( new InputStreamReader(System.in));
                String shuju = br.readLine();
                if(shuju.equals("0")){
                    break;
                }
            //发送数据
           BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bw.write(shuju);
            bw.newLine();
            bw.flush();
            //发送完毕等待服务端给出反馈
            BufferedReader  br1= new BufferedReader(new InputStreamReader(s.getInputStream()));
            String fankui = br1.readLine();
            System.out.println("客服端反馈："+fankui);
        }
         //发送完毕等待服务端给出反馈
            /*InputStream is = s.getInputStream();
            byte[] by =new byte[1024];
            int lenth =is.read(by);
            String data =new String(by,0,lenth);
            System.out.println("客服端反馈："+data);
            System.out.println();*/
        /*    //包装成缓冲字符型
        BufferedReader  br= new BufferedReader(new InputStreamReader(s.getInputStream()));
        String fankui = br.readLine();
        System.out.println("客服端反馈："+fankui);*/
        s.close();
    }
}
