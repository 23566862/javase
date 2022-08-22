package 特殊操作流;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class 字符打印流 {
    public static void main(String[] args) throws IOException {
       /* PrintWriter pw =new PrintWriter("Io\\字符打印流.txt");
        pw.write("asda");
        pw.flush();     //字符流写入数据需要刷新缓冲才能进文件
        pw.write("\r\n");
        pw.write("换行");
        pw.flush();
        pw.println(45);
        pw.println(77);
        pw.flush();*/


        //创建新的构造不需要手动刷新
        PrintWriter pw1 = new PrintWriter(new FileWriter("Io\\字符打印流.txt"), true);
        pw1.println("不需要手动刷新");
        pw1.write("new filewrite");
        pw1.println("特有方法不需要flush");
        pw1.write("wtite需要flush");
        pw1.close();


    }
}
