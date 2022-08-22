package Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JradioButton {
    JradioButton(){
       JFrame jf =new JFrame();
       jf.setSize(400,200);
       Container c =jf.getContentPane();
       c.setLayout(new FlowLayout());
       JRadioButton jf1 =new JRadioButton("按钮1");   //添加单选按钮
        JRadioButton jf2 =new JRadioButton("按钮2");
        jf1.setSelected(true);  //默认选中第一个按钮
        c.add(jf1);
        c.add(jf2);

        ButtonGroup bu =new ButtonGroup();  //按钮足控件

        bu.add(jf1);    //默认只能选择一个单选按钮
        bu.add(jf2);
        JButton jb =new JButton("打印");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(jf1.getText()+"按钮状态:"+jf1.isSelected()); //打印单选按钮名称+状态
                System.out.println(jf2.getText()+"按钮状态:"+jf2.isSelected()); //打印单选按钮名称+状态
                //选中之后清空选择
                bu.clearSelection();
            }
        });
        c.add(jb);
       jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       jf.setVisible(true);
    }
    public static void main(String[] args) {
        new JradioButton();
    }
}
