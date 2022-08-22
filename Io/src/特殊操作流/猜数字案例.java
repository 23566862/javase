package 特殊操作流;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class 猜数字案例 {
    public static void main(String[] args) {
        text();
    }

    //实现游戏内容
    public static void ganme() {
        int num = (int) (Math.random() * 100);
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你要猜的数字：");
            int choie = sc.nextInt();
            if (choie > num) {
                System.out.println("你输入的数字" + choie + "大了");
            } else if (choie < num) {
                System.out.println("你输入的数字" + choie + "小了");
            } else if (choie == num) {
                System.out.println("恭喜你猜对了" + "数字为:" + num);
                break;
            }
        }
    }

    //实现类
    public static void text() {
        try {
            FileReader fr = new FileReader("Io\\game.txt");
            Properties p = new Properties();
            p.load(fr);
            fr.close();
            String value = p.getProperty("count");
            int count = Integer.parseInt(value);
            if (count >= 3) {
                System.out.println("游戏试玩已经结束，想继续请前往（www.game.com）充值");
            } else {
                ganme();
                count++;
                p.setProperty("count", String.valueOf(count));
                FileWriter fw = new FileWriter("Io\\game.txt");
                p.store(fw, null);
                fw.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
