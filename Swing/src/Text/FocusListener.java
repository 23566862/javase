package Text;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.FocusEvent;

public class FocusListener {
    public FocusListener(){
        JFrame jf =new JFrame();
        Container c =jf.getContentPane();
        jf.setBounds(50,50,400,300);
        c.setLayout(new FlowLayout());
        JTextField jt =new JTextField(20);
        JLabel jl =new JLabel("文本框1");
        jt.addFocusListener(new MyFocusListener());
       /* jt.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                jl.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                jl.setText("失去焦点");
                jl.setForeground(Color.red);
            }
        });*/
        c.add(jt);
        c.add(jl);

        JTextField jt1 =new JTextField(20);
        JLabel jl1 =new JLabel("文本框2");
        jt1.addFocusListener(new MyFocusListener());
        /*jt1.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                jl1.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                jl1.setText("失去焦点");
                jl1.setForeground(Color.red);
            }
        });*/
        c.add(jt1);
        c.add(jl1);

        JTextField jt2 =new JTextField(20);
        JLabel jl2 =new JLabel("文本框2");

        jt2.addFocusListener(new MyFocusListener());
        /*jt2.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                jl2.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                jl2.setText("失去焦点");
                jl2.setForeground(Color.red);
            }
        });*/
        c.add(jt2);
        c.add(jl2);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    //自定义 MyFocusListener类 实现FocusListener
    class  MyFocusListener implements java.awt.event.FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            JTextField jt = (JTextField) e.getSource(); //获取要调用的组件
            jt.setText("");
        }

        @Override
        public void focusLost(FocusEvent e) {
            JTextField jt = (JTextField) e.getSource(); //获取要调用的组件
            jt.setText("失去焦点");
            jt.setForeground(Color.red);
        }
    }

    public static void main(String[] args) {
    new FocusListener();
    }
}
