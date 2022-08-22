package Data.src.Data;
import  java.util.Date;
public class MyData {
    public static void main(String [] args){
        Date a =new Date();
        System.out.println(a);
        //setTime()获取从1970年到现在的毫秒值
        System.out.println(a.getTime()/1.0/1000/60/60/24/365);
        //setTime()自己设置时间
        long date =System.currentTimeMillis();  //当前时间
        a.setTime(date);

    }
}
