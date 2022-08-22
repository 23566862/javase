package StuderPaiXu;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class SteuderText {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choie = 0;
        TreeSet<Studer> t = new TreeSet<>(new Comparator<Studer>() {
            @Override
            public int compare(Studer s1, Studer s2) {
                int num = s2.sum() - s1.sum();
                int num2 = num == 0 ? s2.getName().compareTo(s1.getName()) : num;
                return num2;
            }
        });
        for (; ; ) {
            System.out.println("1 添加学生成绩");

            System.out.println("2 排序后学生成绩");
            System.out.println("输入你的选择：");
            choie = sc.nextInt();
            switch (choie) {
                case 1:
                    add(t);
                    break;

                case 2:
                    for (Studer s : t) {
                        System.out.println(s.getChinese() + "," + s.getMath() + "," + s.getEnglish());
                    }
                    break;
            }
        }

    }

    public static void add(TreeSet<Studer> t) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入学生姓名：");
        String name = sc.next();
        System.out.println("输入学生语文成绩：");
        int chinese = sc.nextInt();
        System.out.println("输入学生数学成绩：");
        int math = sc.nextInt();
        System.out.println("输入学生英语成绩：");
        int english = sc.nextInt();
        Studer s = new Studer(name, chinese, math, english);
        t.add(s);
        System.out.println("加添成功");
    }
}
