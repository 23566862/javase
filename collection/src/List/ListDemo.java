package collection.src.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> list =new ArrayList<String>();
        list.add("安段");
        list.add("13");
        list.add("4654");
        Iterator<String> i =list.iterator();
        while(i.hasNext()){
            String s= i.next();
            System.out.println(s);
        }
        System.out.println(list);


    }
}
