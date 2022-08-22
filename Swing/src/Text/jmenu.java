package Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jmenu {
    private JFrame jf =new JFrame("添加图书窗口");
    private Container c =jf.getContentPane();

    JMenuItem jit =new JMenuItem("启动");
    public jmenu(){
        jf.setBounds(400, 200, 700, 800);
        jf.setResizable(false); //窗口固定
        jf.getContentPane().setBackground(Color.pink);  //设置布局颜色
        c.setLayout(null);
        swing();

        jf.setVisible(true);

        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }


    void swing(){
        JMenuBar jb =new JMenuBar();
        JMenu jm =new JMenu("打开");

        jb.add(jm);
        jm.add(jit);
        jit.addActionListener(new abs());
        jf.setJMenuBar(jb);
    }


    public static void main(String[] args) {
        new jmenu();
    }


    private class abs implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jit){

            }

            System.out.println(e.getSource());

        }
    }
}
