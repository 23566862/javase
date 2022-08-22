package For;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class ZengQiang {
    public static void main(String[] args) {
        int [] arr ={1,2,3,4,5};
        //增强for循环，必须时数组或者collection集合
        for (int i:arr){
            System.out.println(i);
        }

        String [] s ={"hello","word","java"};
        for (String s1:s){
            System.out.println(s1);
        }

        Collection<String> c =new ArrayList<>();
        c.add("123");
        c.add("456");
        c.add("478");
        for (String c1:c){
            System.out.println(c1);
        }

    }
}
