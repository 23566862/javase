package Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class 事件处理 {
    JFrame jf =new JFrame();
    Container c =jf.getContentPane();
    public 事件处理(){
        c.setLayout(null);
        jf.setBounds(200,100,300,300);
        TextField tf =new TextField();
        Choice choie =new Choice();
        choie.setBounds(0,0,50,20);
        tf.setBounds(50,0,100,20);

        choie.add("柳岩");
        choie.add("十大");
        choie.add("舒淇");
        //文本域添加内容监听
        tf.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
            //JOptionPane.showMessageDialog(null,tf.getText());
                System.out.println(tf.getText());
            }
        });

        //给下拉框添加监听
        choie.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println( e.getItem());
            }
        });


        //给容器监听添加的所有组件
        jf.addContainerListener(new ContainerListener() {
            @Override
            //添加组件触发
            public void componentAdded(ContainerEvent e) {

            }

            @Override
            //删除触发
            public void componentRemoved(ContainerEvent e) {

            }
        });

        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                
            }
        });

        c.add(tf);
        c.add(choie);
        //jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


   /* private class mylister implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }*/
    public static void main(String[] args) {
    new 事件处理();
    }
}
