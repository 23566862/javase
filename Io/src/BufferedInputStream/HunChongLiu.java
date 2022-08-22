package Io.src.BufferedInputStream;

import java.io.*;


public class HunChongLiu {
    public static void main(String[] args) throws IOException {
        //创建字节缓冲流对象，写入字节
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Io\\BufferedOutput.txt"));
        bos.write("hello\n".getBytes());
        bos.write(12);
        //创建读取文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("Io\\BufferedOutput.txt"));
        byte[] by = new byte[1024];
        int count;
        while ((count = bis.read(by)) != -1) {
            System.out.println(new String(by, 0, count));
        }
        bos.close();
        bis.close();
    }
}
