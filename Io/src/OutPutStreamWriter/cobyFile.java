package Io.src.OutPutStreamWriter;

import java.io.*;

public class cobyFile {
    public static void main(String[] args) throws IOException {
        //复制目录下的java文件
        //创建读取字符流对象
        FileInputStream fis = new FileInputStream("C:\\Users\\86151\\IdeaProjects\\hellword\\Io\\src\\OutPutStreamWriter\\OutPutStreamWriter.java");
        InputStreamReader isr = new InputStreamReader(fis);
        FileOutputStream fos = new FileOutputStream("Io\\coby.java");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        char[] chars = new char[1024];
        int count;
        while ((count = isr.read(chars)) != -1) {
            osw.write(chars, 0, count);
            System.out.println(new String(chars, 0, count));
            osw.flush();
        }
        isr.close();
        osw.close();
    }
}
