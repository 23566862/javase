package 编程三要素;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class inetAddress {
    public static void main(String[] args) throws UnknownHostException {
        //ip地址类的使用
        //该类没有构造方法，方法也不是静态
        //通过ip地址获得对象
        //InetAddress ia = InetAddress.getByName("192.168.1.103");
        //通过主机名
        InetAddress ia = InetAddress.getByName("LAPTOP-AUA335GU");
        //获取对象的主机地址
        String ip = ia.getHostAddress();
        String name = ia.getHostName();
        System.out.println("ip地址:"+ip);
        System.out.println("主机名："+name);
    }
}
