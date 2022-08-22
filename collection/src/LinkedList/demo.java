package collection.src.LinkedList;

import java.util.LinkedList;

public class demo {
    public static void main(String[] args) {
        LinkedList<String> lk =new LinkedList<String>();
        lk.add("hello");
        lk.add("word");
        lk.add("java");

        //在集合表头和表尾插入元素
        lk.addFirst("First");
        lk.addLast("Last");
        System.out.println(lk);

        //返回集合开头和结尾的元素
        System.out.println(lk.getFirst());
        System.out.println(lk.getLast());

        //删除表头和表尾元素
        lk.removeFirst();
        lk.removeLast();
        System.out.println(lk);
    }
}
