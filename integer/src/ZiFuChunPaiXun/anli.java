package integer.src.ZiFuChunPaiXun;

import java.util.Arrays;

public class anli {
    public static void main(String[] args) {
        String  a1 ="44 55 66 77 22 14";
        //帮字符串存储到int 数组中
        String[] a =a1.split(" ");
        //给字符串数组排序，也可以变为int 数组在排序
        Arrays.sort(a);
        //做字符串的拼接
        StringBuilder sb =new StringBuilder();
        for (int i = 0; i <a.length ; i++) {
            if(i ==a.length -1){
                sb.append(a[i]);
            }else{
                sb.append(a[i]).append(" ");
            }
        }

        String s =sb.toString();
        //输出
        System.out.println(s);




    }
}
