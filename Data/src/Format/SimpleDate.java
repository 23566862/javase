package Data.src.Format;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDate {
    public static void main(String[] args) throws ParseException {
        //默认格式输出时间
        Date d =new Date();
        SimpleDateFormat sdf =new SimpleDateFormat();
        String s =sdf.format(d);
        System.out.println(s);
        //有参构造
        SimpleDateFormat sdf1 =new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        //y表示年 M表示月份 d表示日 h表示小时 m表示分 s表示秒
        String s1 =sdf1.format(d);
        System.out.println(s1);

        //自定义格式显示时间
        String s2 ="23-01-25 10:10:30";
        SimpleDateFormat sdf2 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d2 =null;
        try{
             d2 =sdf2.parse(s2);
        }catch (ParseException p){
            System.out.println("格式错误");
        }
        String ss =sdf2.format(d2);
        System.out.println(ss);


        //System.out.println(sdf2.format(d2));






    }
}
