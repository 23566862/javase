package 函数式接口;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

//函数接口spplier的使用
public class supplier {
    public static void main(String[] args) {
        //lambda表达式
        String s = getString(() -> "林青霞");  //接收返回值类型
        System.out.println(s);

        //
        int a =getint(()->100);
        System.out.println(a);
        int [] arr ={45,66,77,100,1,456};
        int Max =Maxint(()->{
            Arrays.sort(arr);
            return arr[arr.length-1];
        });
        System.out.println("最大值：" +Max);

        get("林青霞",System.out::println); //引用方式
        //get("林青霞",(name)-> System.out.println(name));

        //一个参数消费两次
        gettwo("abc",ss-> System.out.print(ss+" "),ss-> System.out.println(new StringBuffer(ss).reverse().toString()));
    }

    //supplier接口
    private static String getString(Supplier<String> su){
        return su.get();
    }

    private static  Integer getint(Supplier<Integer> su){
        return su.get();
    }

    private static int Maxint(Supplier<Integer> su){
        return su.get();
    }

    //Consumer接口的使用
    private static void get(String s, Consumer<String> co){
        co.accept(s);
    }
    //Consumer接口的使用操作两次
    private static void gettwo(String s, Consumer<String> co,Consumer<String> co1){
        co.andThen(co1).accept(s);
    }

}
