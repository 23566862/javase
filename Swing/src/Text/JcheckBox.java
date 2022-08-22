package Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JcheckBox {
    public JcheckBox(){
        JFrame jf =new JFrame();
        jf.setSize(400,200);
        Container c =jf.getContentPane();
        c.setLayout(new FlowLayout());
        //        //添加复选框
        JCheckBox box =new JCheckBox("语文");
        JCheckBox box1 =new JCheckBox("数学");
        JCheckBox box2 =new JCheckBox("英语");
        c.add(box);
        c.add(box1);
        c.add(box2);
        JButton jb =new JButton("确定");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String istrue = istrue(box, box1, box2);
                System.out.println(istrue);
            }
        });
        c.add(jb);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
    public static void main(String[] args) {
        new JcheckBox();
    }

    //打印选中的课程
    public static String istrue(JCheckBox...boxes){
        StringBuffer sb =new StringBuffer();
        for (JCheckBox book:boxes){
            if(book.isSelected()){
                sb.append(book.getText());
            }
        }
        return sb.toString();
    }
}
