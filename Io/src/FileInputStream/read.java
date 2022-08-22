package Io.src.FileInputStream;

import java.io.FileInputStream;
import java.io.IOException;

public class read {
    public static void main(String[] args) throws IOException {
        //字节流读取数据
        FileInputStream fis = new FileInputStream("Io\\OutPutStream.txt");
        //int by =fis.read(); //用int类型接收
        //System.out.println((char)by);   //强制转换

        //接收所有字节流，遍历
        int by;
        while ((by = fis.read()) != -1) {
            System.out.print((char) by);
        }
        fis.close();    //清空缓存
    }

}
