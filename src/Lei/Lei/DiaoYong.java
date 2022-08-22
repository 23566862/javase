package src.Lei.Lei;

import java.util.Scanner;

public class DiaoYong {
    public static void main(String[] args) {
        //创建对象，实现对象
        Scanner sc = new Scanner(System.in);
        LeiDingYi a = new LeiDingYi();
        //使用对象
        int age = sc.nextInt();
        a.name = "小明";
        a.schoolname = "希望小学";
        a.setAge(age);

        System.out.println(a.getAge() + a.name + '\t' + a.schoolname);

        a.homework();
        a.readboook();
        //可以调用多个对象，但是对象的地址不同，值也不同
        //创建第二个对象
        LeiDingYi b = new LeiDingYi();
        //使用对象
        b.name = "小红";
        b.schoolname = "黄埔军校";
        System.out.println(b.name + "," + b.schoolname);
        b.readboook();
        b.homework();
    }
}
