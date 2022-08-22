package intrator;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class BianLi {
    public static void main(String[] args) {
        Collection <String> c =new ArrayList<String>();
        c.add("hello");
        c.add("word");
        c.add("I Like Java");

        //collection里的迭代器
        Iterator<String> it =c.iterator();
        while(it.hasNext()){
            String s =it.next();
            System.out.println(s);
        }


    }
}
