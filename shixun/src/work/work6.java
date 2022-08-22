package work;

import java.util.Calendar;
import java.util.Scanner;

//6、题目：输入某年某月某日，判断这一天是这一年的第几天？
public class work6 {
    public static void main(String[] args) {
        main1();
    }

    //判断是否为数字
    public static boolean string(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main1() {
        Calendar cl = Calendar.getInstance();       //创建日期类
        while (true) {
            int year;
            int month;
            int day;
            System.out.println("请输入年份：");
            Scanner sc = new Scanner(System.in);
            String i = sc.next();
            System.out.println("请输入月份：");
            String b = sc.next();
            System.out.println("请输入日：");
            String c = sc.next();
            if (string(i) && string(b) && string(c)) {
                year = Integer.parseInt(i);
                month = Integer.parseInt(b);
                day = Integer.parseInt(c);
                if ((month > 0 && month <= 12) && (day > 0 && day <= 31)) {
                    cl.set(year, month, day);  //设置当前年月日
                    cl.add(Calendar.MONDAY, -1);     //根据给定的字段去添加或者相减
                    int a = cl.get(Calendar.DAY_OF_YEAR);   //根据给出的字段输出值
                    System.out.println(a);
                } else {
                    System.out.println("你输入的月份或者日期不符合要求");
                    continue;
                }

            } else {
                System.out.println("年月日必须为数字");
            }

        }
    }
}
