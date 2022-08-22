package work7;

import java.util.Scanner;
//7 从键盘输入一年龄数据，当输入的年龄大于50或小于18岁，将抛出自定义异常。输入张三、李四的年龄进行测试
public class ExceptionDemo {
    public static void main(String[] args) throws zidingyiException {
        int age;
        int age1;
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("请输入张三的年龄：");
            String s = sc.next();
            if (string(s)) {
                age = Integer.parseInt(s);
                break;
                }
            else {
                System.out.println("输入的不合法重新输入");
                continue;
            }
        }
        try{
            puanduan(age);
        }catch(zidingyiException e){
            throw new zidingyiException("张三年龄必须大于50或者小于18");
        }

        //李四判断
        while(true) {
            System.out.println("请输入李四的年龄：");
            String s1 = sc.next();
            if (string(s1)) {
                age1 = Integer.parseInt(s1);
                break;
            }
            else {
                System.out.println("输入的不合法重新输入");
                continue;
            }
        }
        try {
            puanduan(age1);
        } catch (zidingyiException e) {
           throw new zidingyiException("李四年龄必须大于50或者小于18");
        }
    }

    //判断方法，抛出自定义异常
    public static void puanduan(int a) throws zidingyiException {
        if (a > 50 || a < 18) {
            throw new zidingyiException("年龄必须大于50或者小于18");
        } else {
            System.out.println("年龄输入正确");
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
    
}
