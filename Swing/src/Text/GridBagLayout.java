package Text;

import javax.swing.*;
import java.awt.*;

public class GridBagLayout {
      JFrame jf =new JFrame();
      Container c;
    public  void createjframe(){
        JFrame jf =new JFrame();
        c=jf.getContentPane();
        c.setLayout(new java.awt.GridBagLayout());
        jf.setSize(800,500);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*GridBagConstraints gc =new GridBagConstraints();
        c.add(new JButton("按钮1"),gc);*/
    }
    void forlayout(){
        for (int i = 0; i <10 ; i++) {
            GridBagConstraints gc =new GridBagConstraints();
            gc.gridx=i;   //起始网格为1
            gc.gridy=0;
            c.add(new JButton("按钮1"),gc);
            GridBagConstraints gc1 =new GridBagConstraints();
            gc1.gridx=0;   //起始网格为1
            gc1.gridy=i;
            c.add(new JButton("按钮1"),gc1);
        }
    }

      void intin(){
          GridBagConstraints gc =new GridBagConstraints();
          gc.gridx=1;   //起始网格为1
          gc.gridy=1;
          gc.gridwidth =2;   //站网格列2个
          gc.gridheight=2;      //占网格行2格
          gc.fill=GridBagConstraints.BOTH;  //根据所对应的占用网格数量，设置填充方式
          /*gc.gridwidth =4;  //设置单元格占的宽，占四个网格
          gc.gridheight=5;  //设置高，占五个*/
          c.add(new JButton("按钮1"),gc);

          GridBagConstraints gc1 =new GridBagConstraints();
          gc1.gridx=4;
          gc1.gridy=4;
          gc1.gridheight=4;
          gc1.gridwidth=4;
          gc1.ipadx=10;//按钮大小+10
          gc1.ipady=10;//按钮大小+10
          //anchor
          gc1.anchor =GridBagConstraints.EAST;   //显示在所占网格数的东方
          c.add(new JButton("按钮1"),gc1);

          gc1.fill=GridBagConstraints.BOTH; //全选填充绿色
          //gc1.anchor=GridBagConstraints.CENTER;
          JPanel p =new JPanel();   //创建一个面板
          p.setBackground(Color.green); //面板变成绿色
          c.add(p,gc1);

          GridBagConstraints gc2 =new GridBagConstraints();
          gc2.gridx=8;
          gc2.gridy=8;
          gc2.gridwidth=2;
          gc2.gridheight=1;
          c.add(new JButton("按钮1"),gc2);
    }
    public static void main(String[] args) {
        GridBagLayout g =new GridBagLayout();
        g.createjframe();
        g.forlayout();
        g.intin();

    }
}
