package integer.src;

public class integer {
    public static void main(String[] args) {
        //int 类型转为 String
        double  num =12.1;
        String s = String.valueOf(num);
        System.out.println(s);
        System.out.println("--------");

        //String 转为 Int
        //方式1   String -Integer -int
        String s1 ="123.1";
        Integer a =Integer.valueOf(s1);
        double num1 =a.intValue();
        System.out.println(num1);
        //方式2
        double x =Integer.parseInt(s1);
        System.out.println(x);
        //装箱
        Integer arr =Integer.valueOf(100);
        //自动装箱
        arr =200;



    }
}
