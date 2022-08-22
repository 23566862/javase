package javaPractice.src.wordPractice;

import java.util.*;

public class day6 {
    public static void main(String[] args) {
    //work1();
        // work2();
       // work3();
        //work4();
        work5();
    }
    public static void work1(){
//        1.创建一个TreeSet集合对象，泛型为Integer类型
//        2.创建Random对象，用于生成随机数
//        3.使用while循环判断集合长度是否不等于10
//        如果长度不为10，则生成随机数保存到集合中
//        4.使用增强for循环遍历集合
        TreeSet<Integer> ts =new TreeSet<>();
        while(ts.size() !=10){
            ts.add((int)(Math.random()*100));
        }
        for (int a:ts){
            System.out.println(a);
        }

    }
    public static void work2(){
        //一、向list集合添加姓名{张三,李四,王五,二丫,钱六,孙七}将二丫替换为王小丫
        String s ="张三,李四,王五,二丫,钱六,孙七";  //字符串分切
        String [] arr =s.split(",");
        ArrayList<String> al =new ArrayList<>();
        for (int i = 0; i <arr.length ; i++) {
            al.add(arr[i]);
        }
        //判断
        for (int i = 0; i <al.size() ; i++) {
            if(al.get(i).equals("二丫")){
                al.set(i,"王二丫");
            }
        }
        //遍历
        for (String s1:al){
            System.out.println(s1);
        }
    }
    public static void work3(){
        //二、使用LinkedHashSet存储以下元素："王昭君","王昭君","西施","杨玉环","貂蝉"
        String s ="王昭君,王昭君,西施,杨玉环,貂蝉";
        String [] arr =s.split(",");
        LinkedHashSet<String> lhs =new LinkedHashSet<>();//LinkedHashSet的存取是有序的
        for (int i = 0; i <arr.length ; i++) {
            lhs.add(arr[i]);
        }
        //for遍历
        for (String s1:lhs){
            System.out.println(s1);
        }
        System.out.println();
        //迭代器
        Iterator<String> it =lhs.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    public static void work4(){
        /*三、双色球规则：
        双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。红色球号码从1—33中选择；
        蓝色球号码从1—16中选择；请随机生成一注双色球号码。（要求同色号码不重复）*/
        HashSet<Integer> hs =new HashSet<>();
        //6个红色球
        while(!(hs.size()==6)){
            hs.add((int)(Math.random()*32+1));
        }
        //蓝色球
        int blue =(int)(Math.random()*15+1);
        System.out.println("你的中奖号码为");
        System.out.print("红色球:");
        for (int a :hs){
            System.out.print(a+" ");
        }
        System.out.println();
        System.out.print("蓝色球：");
        System.out.print(blue);


    }
    public static void work5(){
        /*四、键盘录入一个字符串，去掉其中重复字符，打印出不同的那些字符，
        必须保证顺序。例如输入：aaaabbbcccddd，打印结果为：abcd。
        1，	小提示：String类中有一个方法toCharArray
                方法可以把字符串变成char类型数组*/
        System.out.println("输入一个字符串：");
        Scanner sc =new Scanner(System.in);
        String s =sc.next();
        LinkedHashSet<Character> lhs =new LinkedHashSet<>();
        char[] arr =s.toCharArray();
        for (char a:arr){
            lhs.add(a);
        }
        for (char a:lhs){
            System.out.print(a+" ");
        }

    }
}
