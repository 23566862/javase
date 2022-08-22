import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class methor {
    static long sno =2019010210; //学号
    //添加
    public void add(ArrayList<lei> al){
        int choie;
        while(true) {
            System.out.println("学号自动生成，当前学号为："+sno);
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入学生姓名：");
            String name = sc.next();
            System.out.println("请输入学生数学成绩：");
            int math = sc.nextInt();
            System.out.println("请输入学生计算机成绩：");
            int comput = sc.nextInt();
            System.out.println("请输入学生安卓成绩：");
            int android = sc.nextInt();
            lei l = new lei(String.valueOf(sno++), name, math, comput, android);       //把数据添加到类里
            al.add(l);
            System.out.println("添加成功!");
            System.out.println("是否继续添加学生？按0退出");
             choie =sc.nextInt();
             if(choie ==0){
                 break;
             }else{
                 continue;
             }


        }
    }

    //删除
    public static void remove(ArrayList<lei> al) {
        Scanner sc = new Scanner(System.in);
       boolean b = isnull(al);
        if (b) {
            System.out.println("请添加后学生信息后重试");
        }else{
            System.out.println("请输入你要删除的学号：");
            String xuehao = sc.next();
        for (int i = 0; i < al.size(); i++) {
            lei l = al.get(i);    //接收集合对象
            if (xuehao.equals(l.getSno())) {
                al.remove(i);
                System.out.println("删除成功！");
                break;
            }else if(al.size() -1 ==i){
                System.out.println("没有找到你要删除的学号");
                continue;
            }
        }

    }
    }

    //修改
    public static void xiugai(ArrayList<lei> al) {
        Scanner sc = new Scanner(System.in);
        boolean b = isnull(al);
        if (b) {
            System.out.println("请添加后学生信息后重试");
        }else{
            System.out.println("请输入你要修改的学号：");
        for (int i = 0; i < al.size(); i++) {
            String xuehao = sc.next();
            lei l = al.get(i);
            if (xuehao.equals(l.getSno())) {
                int idex = i;
                System.out.println("请重新输入学生姓名：");
                String name = sc.next();
                System.out.println("请重新输入数学成绩：");
                int math = sc.nextInt();
                System.out.println("请重新输入计算机成绩：");
                int comput = sc.nextInt();
                System.out.println("请重新输入安卓成绩：");
                int android = sc.nextInt();
                //重新给lei赋值
                l.setName(name);
                l.setMath(math);
                l.setComputer(comput);
                l.setAndroid(android);
                al.set(i, l);    //集合修改方法
                System.out.println("修改成功！");
                break;
            } else  {
                System.out.println("没有找到你要修改的学生学号，重新输入");
                continue;
            }
        }
        }
    }

    //查找所有学生
    public void chaxun(ArrayList<lei> al) {
        boolean b = isnull(al);
        if (b) {
            System.out.println("请添加后学生信息后重试");
        }else{
        System.out.println("学号" + '\t' + '\t' + '\t' + '\t' + "姓名" + '\t' + '\t' + "" + "数学" + '\t' + '\t' + "计算机" + '\t' + '\t' + "android" + '\t' + '\t' + "总分");
        for (int i = 0; i < al.size(); i++) {
            lei l = al.get(i);
            System.out.println(l.getSno() + '\t' + '\t' + l.getName() + '\t' + '\t' + '\t' + l.getMath() + '\t' + '\t' + '\t' + l.getComputer() + '\t' + '\t' + '\t' + l.getAndroid() + '\t' + '\t' + '\t' + l.GetSumScore());
        }
        }
    }

    //查找单个学生
    public void oneStuder(ArrayList<lei> al){
        Scanner sc = new Scanner(System.in);
        boolean b = isnull(al);
        if (b) {
            System.out.println("请添加后学生信息后重试");
        }else{
            System.out.println("请输入你要查询的学号：");
        for (int i = 0; i < al.size(); i++) {
            String sno = sc.next();
            lei l = al.get(i);
            if (sno.equals(l.getSno())) {
                System.out.println("学号" + '\t' + '\t' + '\t' + '\t' + "姓名" + '\t' + '\t' + "" + "数学" + '\t' + '\t' + "计算机" + '\t' + '\t' + "android" + '\t' + '\t' + "总分");
                System.out.println(l.getSno() + '\t' + '\t' + l.getName() + '\t' + '\t' + '\t' + l.getMath() + '\t' + '\t' + '\t' + l.getComputer() + '\t' + '\t' + '\t' + l.getAndroid() + '\t' + '\t' + '\t' + l.GetSumScore());
                break;
            } else   {
                System.out.println("没有找到你要查找的学号！重新输入");
                continue;
            }
        }
        }
    }

    //排序输出学生成绩
    public static void MaxStuder(ArrayList<lei> al){
        boolean b = isnull(al);
        if (b) {
            System.out.println("请添加后学生信息后重试");
        }else {
            Collections.sort(al, new Comparator<lei>() {
                @Override
                public int compare(lei l1, lei l2) {
                    int num = l2.GetSumScore() - l1.GetSumScore();
                    return num;
                }
            });
            System.out.println("学号" + '\t' + '\t' + '\t' + '\t' + "姓名" + '\t' + '\t' + "" + "数学" + '\t' + '\t' + "计算机" + '\t' + '\t' + "android" + '\t' + '\t' + "总分");
            for (int i = 0; i < al.size(); i++) {
                lei l = al.get(i);
                System.out.println(l.getSno() + '\t' + '\t' + l.getName() + '\t' + '\t' + '\t' + l.getMath() + '\t' + '\t' + '\t' + l.getComputer() + '\t' + '\t' + '\t' + l.getAndroid() + '\t' + '\t' + '\t' + l.GetSumScore());
            }
        }
    }
    //解决集合为空
    public static boolean isnull(ArrayList<lei> al) {
        boolean b = false;
        if (al.size() == 0) {
            b = true;
        }
        return b;
    }


    //写入文件
    public void outputFile(ArrayList<lei> al) throws IOException {
        FileWriter fos =new FileWriter("SystemStuder\\Student.dat");
        BufferedWriter bw =new BufferedWriter(fos);
        String s;
        for (lei l:al){
            StringBuilder sb =new StringBuilder();
            bw.write(l.getSno()+","+l.getName()+","+l.getMath()+","+l.getComputer()+","+l.getAndroid());
            bw.newLine();   //换行
            bw.flush();
        }
        bw.close();
    }

}
