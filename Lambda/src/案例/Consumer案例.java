package 案例;

import java.util.function.Consumer;

public class Consumer案例 {
    public static void main(String[] args) {
        //实现要求
        //Consumer<String> c1 打印姓名，Consumer<String> c2 打印年龄
        String [] arr ={"李诞，25","汤唯，26","吴彦祖，24","黄小明，20","董大伟，25"};
       /* Stringfor(arr,(String s)->{
            String name =s.split("，")[0];
            System.out.print(name+":");
        },(String s)->{
            int age =Integer.parseInt(s.split("，")[1]);
            System.out.println(age);
        });*/
       //简化
        Stringfor(arr,s -> System.out.print("姓名："+s.split("，")[0]),s -> System.out.println("，年龄："+Integer.parseInt(s.split("，")[1])));
    }

    private  static void Stringfor(String [] arr, Consumer<String> c1,Consumer<String> c2){
        for (String s:arr){
            c1.andThen(c2).accept(s);
        }
    }
}
