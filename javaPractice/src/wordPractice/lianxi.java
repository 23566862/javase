package wordPractice;

import java.util.Arrays;
import java.util.Scanner;

public class lianxi {
    public static void main(String[] args) {
//        methor1();
//        methor2();
//        methor3();
//        methor4();
//        methor5();
//        methor6();
        //methor7();
        //methor8();
        //methor9();
        int [] arr ={95, 92, 75, 56, 98, 71, 80, 58, 91, 91};
        avgsum(arr);
    }

    public static void methor1() {
        int num = 10 > 20 ? 10 : 20;
        System.out.println("最大值为：" + (num > 30 ? num : 30));
    }

    public static void methor2() {
        int temp = 0;
        int num;
        int max = 0;
        for (int i = 0; i < 3; i++) {
            num = (int) (Math.random() * 10);
            System.out.println(num);
            max = num > temp ? num : temp;
            temp = num;
        }
        System.out.println("最大值为：" + max);
    }

    public static void methor3() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num % 2 == 0) {
            System.out.println("这是偶数");
        } else {
            System.out.println("这是奇数");
        }
    }

    public static void methor4() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num > 95 && num <= 100) {
            System.out.println("奖励山地自行车");
        }
        if (num > 90 && num <= 94) {
            System.out.println("游乐园游玩");
        }
        if (num > 85 && num <= 89) {
            System.out.println("奖励变形金刚");
        } else {
            System.out.println("暴揍一顿");
        }
    }

    public static void methor5() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int year = sc.nextInt();
            if (year >= 1 && year <= 3) {
                System.out.println("这是春天");
                break;
            } else if (year >= 4 && year <= 6) {
                System.out.println("这是夏天");
                break;
            }else if (year >= 7 && year <= 9) {
                System.out.println("这是秋天");
                break;
            }else if (year >= 10 && year <= 12) {
                System.out.println("这是春天");
                break;
            }else{
                System.out.println("请输入1-12的月份");
                continue;
            }
        }
    }
    public static void methor6(){
        int sum =0;
        for (int i = 1; i <=100 ; i++) {
            if(i%2 ==0){
                 sum +=i;
            }
        }
        System.out.println("1-100的偶数之和为："+sum);
    }
    public static void methor7(){
        int count=0;
        for (int i = 1; i <1000 ; i++) {
            int bai =i/100;
            int shi =i/10%10;
            int ge =i%100;
            if(bai*bai*bai+shi*shi*shi+ge*ge*ge ==i){
                System.out.println(i);
                count++;
            }
        }
        System.out.println("1000以内的水仙花数有："+count);
    }
    public static void methor8(){
        int [] arr ={11,22,33,44,55,66,77,88,99,100};
        Arrays.sort(arr);
        System.out.println(arr[0]+arr[9]);
    }
    public static void methor9(){
        int[] arr =new int[10];
        int sum =0;
        for (int i = 0; i <arr.length ; i++) {
            arr[i] =(int)(Math.random()*10);
            System.out.println(arr[i]);
            sum += arr[i];
        }
        System.out.println(sum);

    }
    public static void avgsum(int[] arr){
        int sum =0;
        int count =0;
        for (int i = 0; i <arr.length ; i++) {
            sum += arr[i];
        }
        int avg =sum /arr.length;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i] >avg){
                count++;
            }
        }
        System.out.println("平均分高于"+avg+"的人数有:"+count+"个");

    }
}
