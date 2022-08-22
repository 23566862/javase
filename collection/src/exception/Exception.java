package exception;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*
ConcurrentModificationException  并发异常
*/
public class Exception {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list.add("hello");
        list.add("java");
        list.add("my trueLove");
/*
* Exception in thread "main" java.util.ConcurrentModificationException
	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
	at java.util.ArrayList$Itr.next(ArrayList.java:859)
	at exception.Exception.main(Exception.java:18)

        Iterator<String> i =list.iterator();
        while(i.hasNext()){
            String s=i.next();
            if(s.equals("java")){
                list.add("se");
            }
        }
        System.out.println(list);*/

        for (int i = 0; i <list.size() ; i++) {
            String s =list.get(i);
            if(s.equals("java")){
                list.add("真的快乐");
            }
        }
        System.out.println(list);
    }
}
