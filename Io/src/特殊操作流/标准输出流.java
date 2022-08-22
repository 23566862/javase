package 特殊操作流;

import java.io.PrintStream;

public class 标准输出流 {
    public static void main(String[] args) {
        PrintStream ps = System.out;
        ps.write(97);


        ps.println(12);
        ps.print("sda");
        //被静态修饰
        System.out.println(12);
        System.out.print("sda");
    }
}
