package work1;

import java.util.Scanner;

public class work1 {
    public static void main(String[] args) throws Exception {
        Scanner sc =new Scanner(System.in);
        int num;
        while(true) {
            System.out.println("请输入一个整数");
            String s = sc.next();
            if (string(s)) {      //如果是数字就调用
                num = Integer.parseInt(s);
                if(panduan(num)){
                    zhishucount(num);
                }else{
                    System.out.println("不是质数");
                    break;
                }
            }
            else {
                System.out.println("你输入的不是整数");
                continue;
            }
        }

    }

    //判断是否为数字
    public static boolean string(String s){
        for (int i = 0; i <s.length(); i++) {
            char c =s.charAt(i);
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }

    //判断是否为质数
    public static boolean panduan(int a) {
        if (a == 2) {
            return true;
        }
        if (a < 2 || a % 2 == 0) {
            return false;
        }
        for (int i = 3; i < a; i += 2) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String zhishucount(int a) throws Exception {
        StringBuffer buffer = new StringBuffer();
        int sum = 0;
        if (a < 1 || a > 1000) {
          throw new Exception("必须小于1000");
        }
        for (int i = 3; i <= (a / 2); i += 2) {
            for (int j = 3; j < a; j++) {
                if ((i + j) == a && panduan(i) && panduan(j)) {
                    sum++;
                    buffer.append(" ").append("(").append(i).append(",").append(j).append(")");
                }
            }
            buffer.insert(0, sum);
            buffer.setCharAt(1, ' ' );
        }
        return buffer.toString();
    }


}
