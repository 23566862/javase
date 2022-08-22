package work;

import java.util.Scanner;

public class work5 {
    public static void main(String[] args) {
       salaymoney();
    }

    public static void salaymoney(){
        Scanner sc = new Scanner(System.in);
        double money;
        double totalmoney=0;      //提成工资
       while(true){
            System.out.println("输入你的工资：");
            money = sc.nextDouble();
            if(money <0){
                System.out.println("工资不能为负数");
                continue;
            }else{
                money = money / 10000;    //工资
                break;
            }
        }


        if (money <= 10) {
            totalmoney = money * 1.1;
            System.out.println("你的工资为：" + totalmoney + "万元");
        }
        if (money > 10 && money < 20) {
            totalmoney = money + (money * 0.075) + (money - 10) * 0.1;
            System.out.println("你的工资为：" + totalmoney + "万元");
        }
        if (money >= 20 && money < 40) {
            totalmoney = money + (money - 20) * 0.05;
            System.out.println("你的工资为：" + totalmoney + "万元");
        }
        if (money >= 40 && money < 60) {
            totalmoney = money + (money - 40) * 0.03;
            System.out.println("你的工资为：" + totalmoney + "万元");
        }
        if (money >= 60 && money < 100) {
            totalmoney = money + (money - 60) * 0.015;
            System.out.println("你的工资为：" + totalmoney + "万元");
        }
        if (money >= 100) {
            totalmoney = (money - 100) * 0.01;
            System.out.println("你的工资为：" + totalmoney + "万元");

        }
    }
}
