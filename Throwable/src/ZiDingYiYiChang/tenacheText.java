package ZiDingYiYiChang;

import java.util.Scanner;

public class tenacheText {
    public static void main(String[] args) {
        System.out.println("输入学生成绩：");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        techeah t = new techeah();
        try {
            t.panduan(a);
        } catch (ZiDingYi z) {
            z.printStackTrace();
        }
    }
}
