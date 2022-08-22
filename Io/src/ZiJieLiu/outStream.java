package ZiJieLiu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class outStream {
    public static void main(String[] args) throws IOException {
        //创建 输出字节流对象，往文件里写入文件
        //追加写入格式，运行一次写入一次
        //FileOutputStream fos =new FileOutputStream("Io\\OutPutStream.txt",true);

        FileOutputStream fos = new FileOutputStream("Io\\OutPutStream.txt");
        //因为是字节流，所以写入的int类型数据转换为国际信息交换码
        fos.write(97);
        fos.write(12);
        fos.write("\n".getBytes());
        fos.write("字节流".getBytes());
        fos.write("sda".getBytes());

        for (int i = 0; i < 10; i++) {
            fos.write("hello\n".getBytes());
        }
        fos.close();    //关闭此文件并且释放字节流文件相关的资源关闭
    }
}
