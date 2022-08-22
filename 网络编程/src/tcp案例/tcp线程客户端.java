package 网络编程.src.tcp案例;

import java.io.*;
import java.net.Socket;

public class tcp线程客户端 {
    public static void main(String[] args) throws IOException {
        /*try {
            Socket s =new Socket("192.168.1.104",4560);
            BufferedReader br =new BufferedReader(new FileReader(""))
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        Socket s = new Socket("192.168.1.104", 4560);
        BufferedReader br = new BufferedReader(new FileReader("Io\\coby.java"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        BufferedReader brcoll = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String shuju;
        while ((shuju = br.readLine()) != null) {
            bw.write(shuju);
            bw.newLine();
            bw.flush();
        }
        s.shutdownOutput();
        String data = brcoll.readLine();
        System.out.println("客户端" + data);
        s.close();
        br.close();
    }


}
