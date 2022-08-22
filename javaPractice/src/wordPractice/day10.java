package javaPractice.src.wordPractice;

import java.io.*;
import java.util.*;

public class day10 {
    public static void main(String[] args) throws IOException {
        //work1();
        //work2();
        // work3();
        //work4();
        //work5();
        work6();
    }

    //work1
    public static void work1() {
        day10calss d = new day10calss();
        d.setName("小明");
        d.setSex("男");
        d.setAge(20);
        try {
            ObjectOutputStream op = new ObjectOutputStream(new FileOutputStream("javaPractice\\stu.txt"));
            op.writeObject(d);
            op.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //work2
    public static void work2() {
        try {
            ObjectInputStream op = new ObjectInputStream(new FileInputStream("javaPractice\\stu.txt"));
            Object stud = op.readObject();
            day10calss d = (day10calss) stud;//向下转型
            System.out.println(d.getName() + "," + d.getSex() + "," + d.getAge());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //work3
    public static void work3() {
        System.out.println("输入内容:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = br.readLine();
            PrintStream ps = new PrintStream("javaPractice\\d.txt");
            ps.println(s);
            System.out.println("写入成功");
            ps.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //work4
    //读取文件内容，反转再写入其他文件里
    public static void work4() {
        ArrayList<String> al = new ArrayList<>();
        //读取内容
        try {
            BufferedReader br = new BufferedReader(new FileReader("Io\\字符打印流.txt"));
            String s;
            while ((s = br.readLine()) != null) {
                al.add(s);
            }
            //实现反转
            Collections.reverse(al);
            PrintWriter pw = new PrintWriter(new FileWriter("javaPractice\\text1.txt"), true);
            for (int i = 0; i < al.size(); i++) {
                pw.println(al.get(i));
            }
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //work5
    public static void work5() {
        day10calss d = new day10calss();
        ArrayList<day10calss> al = new ArrayList<>();
        al.add(new day10calss("小明", "男", 10));
        al.add(new day10calss("小方", "男", 20));
        al.add(new day10calss("xiaoe", "女", 25));
        try {
            ObjectOutputStream opj = new ObjectOutputStream(new FileOutputStream("javaPractice\\work5.txt"));
            opj.writeObject(al);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //work6
    public static void work6() throws IOException {
        TreeSet<day10calss> ts = new TreeSet<>(new Comparator<day10calss>() {
            @Override
            public int compare(day10calss s1, day10calss s2) {
                int num = s1.getAge() - s2.getAge();
                return num;
            }
        });
        ts.add(new day10calss("小明", "男", 10));
        ts.add(new day10calss("小方", "男", 20));
        ts.add(new day10calss("xiaoe", "女", 25));
        BufferedWriter br = null;
        br = new BufferedWriter(new FileWriter("javaPractice\\work6.txt"));
        for (day10calss d : ts) {
            StringBuilder sb = new StringBuilder();
            sb.append(d.getName()).append(d.getSex()).append(d.getAge());
            br.write(sb.toString());
            br.newLine();
            br.flush();
        }
        br.close();
    }


}


