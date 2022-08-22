package Text;

import javax.swing.*;
import javax.swing.JScrollPane;
import java.awt.*;

public class Jpanle {
    public Jpanle(){
        JFrame jf =new JFrame();
        jf.setBounds(100,100,500,300);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container co =jf.getContentPane();
        co.setLayout(new GridLayout(2,2,10,10));      //使用网格布局2行2列
        //co.add(jf);

        //使用面板Jpanel
        JPanel j1 =new JPanel(new GridLayout(2,3,10,10));   //使用网格边界1行3列
        JPanel j2 =new JPanel(new GridLayout(1,2,10,10));
        JPanel j3 =new JPanel(new BorderLayout());//使用边界布局
        JPanel j4 =new JPanel(new GridLayout(1,1,10,10));
        j1.setBorder(BorderFactory.createTitledBorder("面板1"));  // j1.setBorder设置标题和边界,
        j2.setBorder(BorderFactory.createTitledBorder("面板2"));
        j3.setBorder(BorderFactory.createTitledBorder("面板3"));
        j4.setBorder(BorderFactory.createTitledBorder("面板4"));
        //给面板1添加按钮
        j1.add(new JButton("1"));
        j1.add(new JButton("1"));
        j1.add(new JButton("1"));
        j1.add(new JButton("1"));
        //给面板2添加按钮
        j2.add(new JButton("1"));

        //j3
        j3.add(new JButton("1"),BorderLayout.NORTH);    //因为使用边界布局 设置为顶端
        j3.add(new JButton("1"),BorderLayout.SOUTH);    //底端
        j3.add(new JButton("1"),BorderLayout.WEST);
        j3.add(new JButton("1"),BorderLayout.EAST);
        j3.setBackground(Color.blue);
        //j4
        JTextArea jt =new JTextArea();  //添加文本组件
        JScrollPane jScrollPane =new JScrollPane(jt);
        j4.add(jScrollPane);

        j4.add(jt);
        co.add(j1);
        co.add(j2);
        co.add(j3);
        co.add(j4);
        jf.setVisible(true);
    }
    public static void main(String[] args) {
    new Jpanle();
    }
}
