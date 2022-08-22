package Text;

import javax.swing.*;
import java.awt.*;

public class JScrollPane {
    public JScrollPane(){
        JFrame jf =new JFrame("sd");
        Container co =jf.getContentPane();
        jf.setBounds(100,100,500,300);

        JTextArea jt =new JTextArea();      //添加文本
        javax.swing.JScrollPane js =new javax.swing.JScrollPane(jt);    //参数为要使用滚动面板的组件
        co.add(js);


        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
    public static void main(String[] args) {
        new JScrollPane();
    }
}
