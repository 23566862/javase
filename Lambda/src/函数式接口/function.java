package 函数式接口;

import java.util.function.Function;

public class function {
    public static void main(String[] args) {
        //funciotn("1234",s->Integer.parseInt(s));
        funciotn("1234", Integer::parseInt); //引用形式

        reseov("111", s -> Integer.parseInt(s) + 100, s -> String.valueOf(s));

        String s = "林青霞,30";
        anli(s, s1 -> Integer.valueOf(s1.split(",")[1]) + 70);
    }

    //字符串转int
    private static void funciotn(String s, Function<String, Integer> fun) {
        int a = fun.apply(s);
        System.out.println(a);
    }

    //字符串转int在加上一个int数 然后 int在转String
    private static void reseov(String s, Function<String, Integer> fun, Function<Integer, String> fun1) {
        String s1 = fun.andThen(fun1).apply(s);
        System.out.println(s1);
    }

    private static void anli(String arr, Function<String, Integer> fun) {
        int a = fun.apply(arr);
        System.out.println(a);
    }
}
