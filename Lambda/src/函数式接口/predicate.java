package 函数式接口;

import java.util.ArrayList;
import java.util.function.Predicate;

public class predicate {
    public static void main(String[] args) {
    /*boolean b =isString(20,a-> 30>a,a-> a<100);     //20>33? && 20<100?
        System.out.println(b);*/
        String [] arr ={"李诞，25","汤唯，26","吴彦祖，24","黄小明，27","董大伟，25"};
        ArrayList<String> al =new ArrayList<>();
            al = isname(arr, s1 -> s1.split("，")[0].length() > 2, s1 -> Integer.parseInt(s1.split("，")[1]) > 24);
        al.forEach(System.out::println);

    }

    private static boolean isString(int a, Predicate<Integer> p1, Predicate<Integer> p2){
        //return p1.and(p2).test(a);  //and =&& 与  //or =|| 或 nagate =!
          return  p1.or(p2).negate().test(a);

    }

    //判断数组里的年龄要大于24，名字长度大于2，满足条件就添加到集合
    public static ArrayList<String> isname(String [] arr,Predicate<String> p1, Predicate<String> p2){
        ArrayList<String>  al=new ArrayList<>();
        for (String s:arr){
            if(p1.and(p2).test(s)){
                al.add(s);
            }
        }
        return al;
    }
}
