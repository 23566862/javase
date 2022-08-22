package OutPutStreamWriter;

import java.io.*;

public class OutPutStreamWriter {
    public static void main(String[] args) throws IOException {
        FileOutputStream fil = new FileOutputStream("Io\\OutPutStreamWriter.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fil);
        //字符流写入方式
        //1 写入一个字符
        osw.write(12);  //写入int类型需要刷新

        //2 一次写入一个字节数组
        char[] chars = {'s', 'g', 's', 'w', 'x'};
        osw.write(chars);

        //3 写入部分字节数组
        osw.write(chars, 1, 4);
        osw.flush();
        osw.close();//释放流，先刷新
        FileInputStream fis = new FileInputStream("Io\\OutputStreamWriter.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        char[] chars1 = new char[1024];
        int count;
        while ((count = isr.read(chars1)) != -1) {
            System.out.print(new String(chars));
        }

        isr.close();

    }
}
