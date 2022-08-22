package javaPractice.src.wordPractice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DataPractice {
    public static void main(String[] args) throws ParseException {
       // lianxi();
        //work2();
        //work3();
        //work4();
        work41();
    }

    public static void work1() throws ParseException {
        //获取自己出生日期
        Scanner sc =new Scanner(System.in);
        System.out.println("请输入你的出生日期 ：日期格式为：yyyy-MM-dd");
        String data =sc.next();
       SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");   //日期格式
        Date d =sdf.parse(data);
        //获取毫秒值
        long chusheng =d.getTime();
        //获取当前日期和毫秒值
        Date d1 =new Date();
        long dangqian =d1.getTime();
        //把毫秒值变为天数
        long tianshu =dangqian-chusheng;
        System.out.println("出生天数为:"+tianshu/1000/60/60/24+"天");
    }

    public static void work2(){
//        一、请用代码实现:获取当前的日期,
//           并把这个日期转换为指定格式的字符串,
//           如2088-08-08 08:08:08
        Date d =new Date(); //获取当前日期
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");//更改格式
        String date =sdf.format(d); //转为字符串类型
        System.out.println(date);
    }
    public static void work3() throws ParseException {
        //二、使用SimpleDateFormat类,把2018-03-04转换为2018年03月04日
        String date ="2018-03-04";
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        Date d =sdf.parse(date);
        SimpleDateFormat sdf1 =new SimpleDateFormat("yyyy年MM月dd日");
        String date1 =sdf1.format(d);
        System.out.println(date1);
    }
    //calendar类解决
    //用程序判断2018年2月14日是星期几
    public static void work4(){
        Calendar c = Calendar.getInstance();
        c.set(2018,2,14);       //设置年月日
        int moth =c.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println("今天是星期"+moth);
    }


    //解决方案2
    //用程序判断2018年2月14日是星期几
    public static void work41() throws ParseException {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd-EE");    //e表示星期
        SimpleDateFormat sdf1 =new SimpleDateFormat("yyy-MM-dd");
        Date e =sdf1.parse("2018-2-14");
        String s =sdf.format(e);
        System.out.println(s);
    }
}
