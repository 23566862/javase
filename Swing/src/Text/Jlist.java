package Text;

import javax.swing.*;
import javax.swing.JScrollPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Jlist {    //列表框组件
    public Jlist(){
        JFrame jf =new JFrame();
        Container c =jf.getContentPane();
        c.setLayout(null);
        jf.setBounds(10,10,100,300);
        String [] arr ={"元素1","元素2","元素3","元素4","元素5","元素6"};
        JList<String> jl =new JList<>(arr);
        //jl.setBounds(10,10,50,100);
        //c.add(jl);
        //设置选择列表的方式
        /*MULTIPLE_INTERVAL_SELECTION  随便选
        SINGLE_SELECTION 只能单选
        * */
        jl.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        //当元素列表展示不出，使用下拉框展示
        JScrollPane JS =new JScrollPane(jl);
        JS.setBounds(10,10,60,100);
        JButton jb =new JButton("打印");
        jb.setBounds(100,10,80,20);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //打印所选选项
                List<String> list = jl.getSelectedValuesList();
                String s1 ="";
                for (String s:list){
                    s1+=s+",";
                }
                JOptionPane.showMessageDialog(null,s1);
            }
        });
        c.add(jb);
        c.add(JS);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
    new Jlist();
    }
}
