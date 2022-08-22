package Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dialog1 {
    public static void main(String[] args) {
        JFrame jf =new JFrame();
        Container c =jf.getContentPane();
        jf.setLayout(null);
        jf.setSize(300,400);
        JButton jb =new JButton("模式对话框");
        JButton jb1 =new JButton("非模式对话框");
        jb.setBounds(20,20,150,60);
        jb1.setBounds(20,100,150,60);


        Dialog d1 =new Dialog(jf,"模式对话框",true);
        Dialog d2 =new Dialog(jf,"非模式对话框",false);
        //在对话框中添加文本和按钮
        Box box =Box.createHorizontalBox();
        box.add(new TextArea());

        box.add(new JButton("确定"));
        box.add(new JButton("取消"));
        d1.setBounds(20,20,200,200);
        d2.setBounds(20,20,150,100);
        JOptionPane.showMessageDialog(null,"信息的弹框","重载2",3);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d1.add(box);
                d1.setVisible(true);

            }
        });

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d2.setVisible(true);
            }
        });

        c.add(jb);
        c.add(jb1);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
