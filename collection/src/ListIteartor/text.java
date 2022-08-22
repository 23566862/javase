package collection.src.ListIteartor;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class text {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list.add("hello");
        list.add("java");
        list.add("my trueLove");

        ListIterator<String> li =list.listIterator();

       while(li.hasNext()){
           String s =li.next();
           if(s.equals("hello")){
               li.add("添加成功");
           }
       }
        System.out.println(list);

       while(li.hasPrevious()){
           String s =li.previous();
           System.out.println(s);
       }
    }
}
