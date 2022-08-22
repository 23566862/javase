package Radom;


import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class Radom {
    public static void main(String[] args) {
        TreeSet<Integer> t = new TreeSet<>();
        Random r = new Random();
        while (t.size() < 10) {
            int num = r.nextInt(20) + 1;
            t.add(num);
        }
        for (Integer i : t) {
            System.out.println(i);
        }
        ArrayList<String> al = new ArrayList<String>();
        al.add("sdadad");
        al.add("3-2");
        for (String s : al) {
            System.out.println(s);
        }
    }
}
