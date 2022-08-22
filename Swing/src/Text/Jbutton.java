package Text;

import com.sun.jndi.toolkit.url.UrlUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jbutton {
    public Jbutton(){
        JFrame jf =new JFrame("sd");
        Container co =jf.getContentPane();
        jf.setBounds(100,100,500,300);
        Container c =jf.getContentPane();
        c.setLayout(new GridLayout(3,2,10,10));
        JButton  jb[] =new JButton[6];
        for (int i = 0; i <jb.length; i++) {
            jb[i]=new JButton();
            c.add(jb[i]);
        }
        //jb0
        jb[0].setText("按钮1不可用");    //按钮文本
        jb[0].setEnabled(false);    //设置按钮不可点击
        //jb1
        jb[1].setText("按钮2有背景色");
        jb[1].setBackground(Color.BLACK);

        //jb2
        jb[2].setText("无边框");
        jb[2].setBorderPainted(false);  //不显示边框

        //jb3
        jb[3].setText("设置边框颜色");
        jb[3].setBorder(BorderFactory.createLineBorder(Color.yellow));  //设置边框颜色位黄色

        //jb4使用自己的图片当按钮
        Icon i =new ImageIcon("Swing\\src/Text/sda.jpg");
        jb[4].setIcon(i);

        //jb5
        jb[5].setText("按钮5");
        jb[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"点击提示");
            }
        });

        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
    public static void main(String[] args) {
        new Jbutton();
        /*JFrame jf =new JFrame();
        jf.setBounds(1,1,10000,10000);
        Container c =jf.getContentPane();
        JButton jb =new JButton();
        Icon con =new ImageIcon("src/sda.jpg");
        jb.setIcon(con);
        c.add(jb);
        jf.setVisible(true);*/
    }
}
