package Io.src.CobyFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FuZhiFile {
    //复制文件思路
    //1 读取你要复制的文本文件
    //2 写入你读取的文件
    // 3 读取一个写入一个
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("Io\\OutPutStream.txt");
        FileOutputStream fos = new FileOutputStream("Io\\ioException.txt");
        int by;
        //读取和写入
        while ((by = fis.read()) != -1) {
            fos.write(by);
        }

        //释放资源
        fis.close();
        fos.close();

    }
}
