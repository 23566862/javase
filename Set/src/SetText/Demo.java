package SetText;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        Set<String> s = new HashSet<String>();
        //不可以存储重复内容，不可以使用for循环，找不到缩影
        //对集合迭代循序随机
        s.add("hello");
        s.add("word");
        s.add("java");
        s.add("word");
        for (String s1 : s) {
            System.out.println(s1);
        }

    }
}
