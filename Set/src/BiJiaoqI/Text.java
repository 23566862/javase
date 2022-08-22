package BiJiaoqI;

import java.util.Comparator;
import java.util.TreeSet;

public class Text {
    public static void main(String[] args) {
        //Treeset比较器模式比较，有参构造
        TreeSet<Studer> t = new TreeSet<Studer>(new Comparator<Studer>() {
            @Override
            public int compare(Studer s1, Studer s2) {
                int num = s1.getAge() - s2.getAge();
                int num2 = num == 0 ? s1.getName().compareTo(s2.getName()) : num;
                return num2;
            }
        });
        Studer s = new Studer("a林青霞", 20);
        Studer s1 = new Studer("b貂蝉", 30);
        Studer s2 = new Studer("z杨玉环", 25);
        Studer s3 = new Studer("d虞姬", 29);
        Studer s4 = new Studer("a虞", 29);
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
