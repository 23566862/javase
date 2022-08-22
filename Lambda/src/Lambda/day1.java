package Lambda.src.Lambda;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day1 {
    public static void main(String[] args) {
        //lambda表达式写法,线程举例
        new Thread(()->
            System.out.println("线程启动")
        ).start();
        //线程方法2
        Runnable r=()-> System.out.println("线程2");
        r.run();

        //方法1
        String []  arr ={"133","sda","888","无敌","Lambda表达式"};
        List<String> al = Arrays.asList(arr);
        al.forEach((add)->{
            System.out.println(add+",");
        });
       //jdk8版本写法
        al.forEach(System.out::println);
    }
}
