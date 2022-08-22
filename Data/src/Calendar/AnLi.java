package Data.src.Calendar;
import java.util.Calendar;

import java.util.Scanner;
public class AnLi {
    public static void main(String[] args) {
        Calendar c =Calendar.getInstance();
        System.out.println("请输入年份：");
        Scanner sc =new Scanner(System.in);
        int i =sc.nextInt();
        System.out.println("请输入月份：");
        int b =sc.nextInt();
        //判断二月有多少天
        c.set(i,b,1);
        //把日期日设置为第一天，然后减一
        c.add(Calendar.DATE,-1);
        int a =c.get(Calendar.DATE);
        System.out.println("这个月有："+a+"天");
    }
}
