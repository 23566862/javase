package 函数式接口;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class text {
    public static void main(String[] args) {
        intefaceOne i =()-> System.out.println("函数时接口");    //接口作为对象
        i.show();
        //函数式接口参数问接口的时候
        //1匿名内部类
        thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"线程已启动");
            }
        });

       //lambda形式
        thread(()-> System.out.println(Thread.currentThread().getName()+"线程已启动"));

        String [] arr ={"a","bbb","ssss","sdadff","ss"};
        List<String> al = Arrays.asList(arr);
        System.out.println("排序前："+al);
        Collections.sort(al);   //按照自然排序排序
        System.out.println("自然排序排序"+al);
        Collections.sort(al,comp()); //按照字符串长度排序
        System.out.println("长度排序"+al);
    }

    //接口作为参数
    public static void thread(Runnable r){
        /*Thread t =new Thread(r);
        t.start();*/
        new Thread(r).start();
    }

    //返回值是接口
    public static Comparator<String> comp(){
        return (s1,s2)->s1.length()-s2.length();
    }

}
