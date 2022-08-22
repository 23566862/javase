package work8;

import java.util.Scanner;
/*构造方法与重载 定义一个网络用户类 要处理的信息有用户ID、用户密码、email地址。
在建立类的实例时 把以上三个信息都作为构造函数的参数输入 其中用户ID和用户密码时必须的
缺省的email地址是用户ID加上字符串"@gameschool.com"
        测试用例：1、1201012204,"dwajldwajlj",1111111111@gameschool.com
          2、1201012204,"dwijadiwjal"*/

public class demo {
    public static void main(String[] args) {
        text();
    }

    public static void text() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账号：");
        String zhanghao = sc.next();
        System.out.println("请输入密码：");
        String psword = sc.next();
        System.out.println("是否输入邮箱？");
        while (true) {
            System.out.println("1 不输入");
            System.out.println("2 输入");
            int choie = sc.nextInt();
            if (choie == 1) {
                lei l = new lei(zhanghao, psword);
                break;
            } else if (choie == 2) {
                System.out.println("请输入邮箱:");
                String e_mail = sc.next();
                lei l = new lei(zhanghao, psword, e_mail);
                break;
            } else {
                System.out.println("只能输入1和2");
                continue;
            }

        }

    }
}
