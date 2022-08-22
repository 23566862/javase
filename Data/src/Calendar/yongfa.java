package Data.src.Calendar;

import java.util.Calendar;

public class yongfa {
    public static void main(String[] args) {
        //创建对象
        Calendar c = Calendar.getInstance();
        int i = c.get(Calendar.YEAR);  //获取年
        int a = c.get(Calendar.MONDAY)+1;  //获取月
        int b = c.get(Calendar.DATE);    //获取日
        int d =c.get(Calendar.DAY_OF_WEEK)-1; //星期几
        System.out.println(i+"年"+a+"月"+b+"日"+"星期"+d);
        //add方法加减日期时间
        System.out.println("----------------");
        c.add(Calendar.YEAR,+1);
        c.add(Calendar.MONDAY,-3);
         i = c.get(Calendar.YEAR);  //获取年
         a = c.get(Calendar.MONDAY)+1;  //获取月
         b = c.get(Calendar.DATE);    //获取日
        System.out.println(i+"年"+a+"月"+b+"日"+"星期"+d);

        //
        System.out.println("----------------");
        c.set(2020,2,1);
       c.add(Calendar.DATE,-1);
        System.out.println(i+"年"+a+"月"+b+"日"+"星期"+d);


    }
}