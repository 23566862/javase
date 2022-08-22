package Io.src.FileInputStream;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadArray {
    public static void main(String[] args) throws IOException {
        //字节流读取数据（一次读取数组字节）
        byte[] by = new byte[1024];  //容量最好是1024的倍数
        FileInputStream fis = new FileInputStream("Io\\ioException.txt");
        int count;
        // System.out.println(count);      //显示字节数组接收了几个数据
        //System.out.println(new String(by)); //输出数据，如果文件里有换行，默认存储\r\n
        //System.out.println(new String(by,0,count));
        while ((count = fis.read(by)) != -1) {
            System.out.println(new String(by, 0, count));
        }
    }
}
