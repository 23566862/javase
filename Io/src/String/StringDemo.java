package String;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //字符串里的编码解码问题
        //编码
        //1 getbytes()无参，用软件自带编码表
        //1 getbytes（String:name）有参，用指定编码表

        //解码
        //1 String s=new String();   无参
        //2 String(String:name)     //指定编码表
        //注意：编码和解码必须采用同一个编码表

        //无参编码
        String s = "中国";
        byte[] by = s.getBytes();        //默认采用utf-8
        System.out.println(Arrays.toString(by));//[-28, -72, -83, -27, -101, -67]
        //采用指定GBK编码
        byte[] by1 = s.getBytes("GBK");
        System.out.println(Arrays.toString(by1));

        //解码
        String s1 = new String(by);
        System.out.println(s1);

        //指定方式解码
        String s2 = new String(by1, "UTF-8");
        System.out.println(s2);
    }
}
