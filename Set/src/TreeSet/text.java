package TreeSet;

import java.util.TreeSet;

public class text {
    public static void main(String[] args) {
        TreeSet<String> t = new TreeSet<>();
        t.add("adsd");
        t.add("nsd");
        t.add("sda");
        t.add("123");
        for (String s : t) {
            System.out.println(s);
        }
    }
}
