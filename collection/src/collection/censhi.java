package collection.src.collection;

import java.util.ArrayList;
import java.util.Collection;

public class censhi {
    public static void main(String[] args) {
        Collection <String> c =new ArrayList<String>();
        c.add("123");
        c.add("456");
        c.add("789");
        System.out.println(c);
        //删除
        c.remove("123");
        System.out.println(c);

        //清空
        c.clear();

        //判断集合是否有指定元素
        System.out.println(c.contains("123"));

        //判断集合是否为空
        System.out.println(c.isEmpty());

        //判断集合元素个数
        System.out.println(c.size());



    }
}
