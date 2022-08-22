package collection.src.CollectionStudetentConsole;

import collection.src.CollectionStudetentConsole.Student;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class test {
    public static void main(String[] args){
        int choie =0;
        Collection<Student> c =new ArrayList<>();
        do {
            System.out.println("输入学生姓名：");
            Scanner sc =new Scanner(System.in);
            String name =sc.next();
            System.out.println("输入学生年龄：");
            int age =sc.nextInt();
            System.out.println("输入学生地址：");
            String address =sc.next();
            Student s =new Student(age,name,address);
            c.add(s);
            System.out.println("1 继续输入：");
             choie =sc.nextInt();
        }while(choie ==1);

        Iterator<Student> i =c.iterator();
        while(i.hasNext()){
            Student s =i.next();
            System.out.println(s.getAge()+","+s.getName()+","+s.getAddress());
        }


    }
}
