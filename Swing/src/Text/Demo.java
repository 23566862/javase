package Text;

import javax.swing.*;
import java.awt.*;

public class Demo {
    public static void main(String[] args) {
        /*JFrame jf =new JFrame();            //创建窗口对象
        Container con =jf.getContentPane();     //窗口对象放进容器
        JLabel jb =new JLabel("窗口");       //在窗口里添加标签
        jb.setHorizontalAliment(SwingConstants.CENTER);   //使标签居中
        con.add(jb);    //把标签内容放进容器
       jf.setVisible(true);    //显示窗口
        jf.setSize(300,150);    //调整窗体大小，长和高*/
        //con.add(new JButton("12313"));


        JFrame jf =new JFrame("第一个窗口");    //窗口对象   //参数设置窗口标题
        Container co =jf.getContentPane();  //窗口容器
        co.setBackground(Color.getColor("绿色",Color.blue));
        jf.setSize(400,200);    //设置窗口长和高
        JLabel jl =new JLabel("JFrame窗口");  //创建设置窗口标签组件
        jl.setHorizontalAlignment(SwingConstants.CENTER);   //设置窗口居中
        co.add(jl); //把标签组件放进窗口
        jf.setVisible(true);    //显示窗口
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
}
