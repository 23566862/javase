package work;

import java.util.Arrays;
import java.util.Scanner;
//2 从键盘输入任意个整数数字，如果输入0则结束输入，输出输入的数以及总和
public class work2 {
    public static void main(String[] args) {
        System.out.println(sum());
    }

    public static int sum() {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int num;
        for (int i = 0; ; i++) {
            System.out.println("请输入第" + (i + 1) + "个数：");
            String sum = sc.next();
            if(string(sum)){
                num =Integer.parseInt(sum); //转换为int类型
                if (num > 0 && num < 1000) {
                    max = max + num;
                    System.out.println("输入0退出");
                } else if (num == 0) {
                    break;
                }else if(num >1000){
                    System.out.println("必须小于1000");
                }
            }else{
                System.out.println("你输入的数必须是正数");
                continue;
            }
        }
        return max;
    }

    //判断是否为数字
    public static boolean string(String s){
        for (int i = 0; i <s.length() ; i++) {
            char c =s.charAt(i);
            if(!Character.isDigit(c)){  //是否为数字
                return false;
            }
        }
        return true;
    }
}


