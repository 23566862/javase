package Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JpsswordFiled {
    //密码框组件
    JpsswordFiled(){
        JFrame jf =new JFrame();
        jf.setBounds(100,100,400,100);
        Container c =jf.getContentPane();
        c.setLayout(new FlowLayout());
        JPasswordField jp =new JPasswordField(20);  //设置密码框大小
        //jp.setFont(new Font("宋体",Font.BOLD,10));
        jp.setEchoChar('#');   //设置反显样式
        jp.addActionListener(new ActionListener() {     //监听输入的内容，回车输出
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] arr = jp.getPassword();
                JOptionPane.showMessageDialog(null,new java.lang.String(arr));
            }
        });
        c.add(jp);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JpsswordFiled();
    }
}
