package HashSet;

import java.util.HashSet;

public class text {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        //添加元素不可重复
        hs.add("HashGet");
        hs.add("word");
        hs.add("sdsad");
        hs.add("hello");
        //遍历顺序也时随机的
        /*for(String s:hs){
            System.out.println(s);
        }*/

        //lambda表达式遍历
        hs.forEach(a -> System.out.println(a + ","));

    }
}
