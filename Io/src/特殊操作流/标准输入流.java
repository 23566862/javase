package 特殊操作流;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 标准输入流 {
    public static void main(String[] args) throws IOException {
       /* InputStream is =System.in;
        //byte[] bys =new byte[1024];
        int by;
        while( (by=is.read())!=-1){
            //System.out.println(new String(bys,0,by));
            System.out.print((char)by);
        }*/

        //使用标准输入流读取输入的数据
        //缓冲字符流->字符流->字节流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个字符串:");
        String s = br.readLine();       //一次读取一行数据
        System.out.println("字符串是：" + s);
        //如果要输入int类型，则先判断是否为纯数字，是的话就转换

    }
}
