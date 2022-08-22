package Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class lei {
    public static void main(String[] args) {
        int num =100;
        JFrame jf =new JFrame();
        Container c =jf.getContentPane();
        jf.setSize(500,600);
        JTextField jt [] =new JTextField[5];
        JButton jb =new JButton("按钮");
        
        jb.setEnabled(false);
        jb.setBounds(50,50,100,20);
        c.add(jb);
        for (int i = 0; i <jt.length ; i++) {
            jt[i] =new JTextField();
            jt[i].setBounds(100,num,200,30);
            num+=100;
            c.add(jt[i]);
        }

        //jb.addKeyListener(new );

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
