package Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//下拉框联动
public class 下拉列表联动 {
    JFrame jf =new JFrame();
    Container co =jf.getContentPane();
    //    声明下来列表JComboBox
    private JComboBox choice1;
    private JComboBox choice2;

    //定义一个数组
    private static String[] s1 = {"中国","美国","日本","澳大利亚","法国","德国","英国"};
    private static String[][] s2 = {
            {"北京","上海","广州","深圳"},
            {"华盛顿","纽约","芝加哥","旧金山"},
            {"东京","大阪","名古屋","北海道"},
            {"悉尼","堪培拉","珀斯"},
            {"巴黎","南特","德勒","鲁昂"},
            {"柏林","华沙","卢布林","波兹南"},
            {"伦敦","曼切斯特","诺丁汉","牛津"}
    };
    public 下拉列表联动(){
        jf.setBounds(400, 200, 700, 800);
        jf.setResizable(false); //窗口固定
        jf.getContentPane().setBackground(Color.pink);  //设置布局颜色
        co.setLayout(null);

        swing();

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    void swing(){
        //下拉框1
        choice1 =new JComboBox(s1);
        choice1.setBounds(100,100,100,30);
        choice1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //从项目列表中删除所有项目。
                choice2.removeAllItems();
               JComboBox jc =(JComboBox) e.getSource();
               //获取当前选中的strng 和下标
               String items =(String) jc.getSelectedItem();
                System.out.println(items);
                int idex =jc.getSelectedIndex();
                //根据下标存放对应的下拉列表里的数据
                for (int i = 0; i <s2[idex].length ; i++) {
                    choice2.addItem(s2[idex][i]);
                }
            }
        });

        //下拉框2
        choice2 =new JComboBox(s2[0]);  //创建实例化对象,初始的数据
        choice2.setBounds(300,100,100,30);
        /*choice2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() ==ItemEvent.SELECTED){
                    String itemString =(String) e.getItem();
                    System.out.println(itemString);
                }
            }
        });*/
        co.add(choice2);

        co.add(choice1);
    }

    public static void main(String[] args) {
    new 下拉列表联动();
    }
}
