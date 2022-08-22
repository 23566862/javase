package Text;

import javax.swing.*;
import javax.swing.JScrollPane;
import java.awt.*;

public class JtextArea {
    public JtextArea(){
        JFrame jf =new JFrame();
        jf.setBounds(100,100,300,400);
        jf.setVisible(true);
        Container c =jf.getContentPane();
        c.setLayout(new FlowLayout());
        JTextArea ja =new JTextArea();
        ja.setSize(50,100);
        ja.setRows(5);  //5行
        ja.setColumns(10);  //10列

        ja.setFont(new Font("楷体",Font.PLAIN,20));
        JScrollPane js =new JScrollPane(ja);
        c.add(js);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new JtextArea();
    }
}
