package 特殊操作流;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class 字节打印流 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream("Io\\打印流.txt");
        //使用自己的方法
        ps.write(97);   //写入的是小a

        //使用特有方法
        ps.println(45);     //直接写入45
        ps.println("sda");  //直接写入sda
    }
}
