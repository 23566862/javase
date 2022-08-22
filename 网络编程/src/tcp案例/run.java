package tcp案例;

import java.io.*;
import java.net.Socket;

public class run implements Runnable {
    private Socket socket;

    public run(Socket s) {
        this.socket = s;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            int count = 0;
            /*BufferedWriter bw =new BufferedWriter(new FileWriter("网络编程\\tcp.txt"));*/
            //给文件给定不同名称
            File f = new File("网络编程\\coby[" + count + "].txt");
            while (f.exists()) {
                count++;
                f = new File("网络编程\\coby[" + count + "].txt");
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            BufferedWriter bwkefu = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String string;
            while ((string = br.readLine()) != null) {
                bw.write(string);
                bw.newLine();
                bw.flush();
            }
            bwkefu.write("服务器接收成功！");
            bwkefu.newLine();
            bwkefu.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
