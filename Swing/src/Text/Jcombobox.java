package Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jcombobox {
    //下拉列表框
    public Jcombobox(){
        JFrame jf =new JFrame();
        Container c =jf.getContentPane();
        c.setLayout(null);
        jf.setSize(800,500);
        String arr[]={"身份证","学生证","港澳台证"};
        JComboBox<String> jc =new JComboBox<>(arr);
        jc.setEditable(true);   //下拉列表框可以编辑
        jc.setBounds(20,10,80,20);
        JButton jb =new JButton("打印");
        jb.setBounds(100,10,80,20);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //打印所选选项
                JOptionPane.showMessageDialog(null,jc.getSelectedItem());
            }
        });
        c.add(jb);
        c.add(jc);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Jcombobox();
    }
}
