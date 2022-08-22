package Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JtextField {
    public JtextField(){
        JFrame jf =new JFrame();
        jf.setBounds(0,0,400,300);
        Container c =jf.getContentPane();
        FlowLayout fl=new FlowLayout( FlowLayout.TRAILING);
        c.setLayout(fl);

        JLabel jl =new JLabel("账号：");
        c.add(jl);

        JTextField jt =new JTextField(23);    //设置文本框大小
        jt.setFont(new Font("黑体",Font.PLAIN,20));
        c.add(jt);

        JLabel jl1 =new JLabel("密码：");
        c.add(jl1);

        JTextField jt1 =new JTextField(20);    //设置文本框大小
        jt1.setFont(new Font("黑体",Font.PLAIN,20));
        c.add(jt1);



        JButton jb =new JButton("确定");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,jt.getText());
                jt.setText(""); //清空输入内容
                jt.requestFocus();  //获得这个文本框的焦点
            }
        });

            c.add(jb);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new JtextField();
    }
}
