package Io.src.jpgInput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class jpg {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\heima\\jpg.png"); //创建读取文件对象
        FileOutputStream fos = new FileOutputStream("Io\\JPG.png");
        byte[] by = new byte[1024];
        int count;
        while ((count = fis.read(by)) != -1) {
            fos.write(by, 0, count);
        }
        fis.close();
        fos.close();    //释放内存


    }
}
