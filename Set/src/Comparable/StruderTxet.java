package Comparable;

import java.util.TreeSet;

public class StruderTxet {
    public static void main(String[] args) {
        Studer s = new Studer("a林青霞", 20);
        Studer s1 = new Studer("b貂蝉", 30);
        Studer s2 = new Studer("z杨玉环", 25);
        Studer s3 = new Studer("d虞姬", 29);
        Studer s4 = new Studer("a虞", 29);
        TreeSet<Studer> t = new TreeSet<Studer>();
        t.add(s);
        t.add(s1);
        t.add(s2);
        t.add(s3);
        t.add(s4);
        for (Studer studer : t) {
            System.out.println(studer.getName() + "," + studer.getAge());
        }


    }
}
