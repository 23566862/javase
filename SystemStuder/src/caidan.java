import javafx.scene.chart.ScatterChart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class caidan  {
    public  caidan() throws IOException {
        methor m =new methor();
        Scanner sc = new Scanner(System.in);
        ArrayList<lei> al = new ArrayList<lei>();   //创建集合
        for (; ; ) {
            System.out.println("---------欢迎使用学生管理系统---------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 按学号查找单个学生");
            System.out.println("6 按成绩查看学生");
            System.out.println("7 保存输入的内容");
            System.out.println("8 退出系统");
            System.out.println("请输入你的选择：");
            int choie = sc.nextInt();
             try{
            switch (choie) {
                case 1:
                    //添加学生
                    m.add(al);
                    break;
                case 2:
                    //删除学生
                    m.remove(al);
                    break;

                case 3:
                    //修改学生
                    m.xiugai(al);
                    break;
                case 4:
                    //查找所有学生
                    m.chaxun(al);
                    break;
                case 5:
                    //按学号查找单个学生
                    m.oneStuder(al);
                    break;
                case 6:
                    //按成绩查看学生
                    m.MaxStuder(al);
                    break;
                case 7:
                    m.outputFile(al);
                    break;
                case 8:
                    //退出系统
                    System.out.println("谢谢使用");
                    System.exit(0);
                    break;
                default:
                    System.out.println("请输入1-7的数字");
                    continue;
            }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }
}
