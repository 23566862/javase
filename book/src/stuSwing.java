package book.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class stuSwing {
    private JMenuItem jmits[] = new JMenuItem[4];
    private String jmitsname[] = {"图书借阅", "图书归还", "图书查询", "打印报表"};
    private JFrame jf = new JFrame("学生窗口");
    private Container c = jf.getContentPane();
    private JMenuBar jmb = new JMenuBar();

    public stuSwing() {
        jf.setBounds(400, 200, 700, 800);
        jf.setResizable(false); //窗口固定
        jf.getContentPane().setBackground(Color.pink);  //设置布局颜色
        c.setLayout(null);

        swing();

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }


    void swing() {
        //文本
        JLabel jl = new JLabel();
        jl.setText("欢迎学生使用图书管理系统");
        Font f = new Font("宋体", Font.PLAIN, 30);
        jl.setFont(f);      //字体样式font
        jl.setForeground(Color.blue);
        jl.setBounds(150, 50, 600, 100);

        //获取us类里的数据，登入人员的姓名和id
        JLabel jl1 = new JLabel();
        jl1.setText("姓名：" + loingView.name);
        jl1.setBounds(220, 150, 600, 100);
        jl1.setFont(f);
        jl1.setForeground(Color.red);
        //id
        JLabel jl2 = new JLabel();
        jl2.setText("借阅证：" + loingView.idcard);

        jl2.setBounds(220, 250, 600, 100);
        jl2.setFont(f);
        jl2.setForeground(Color.red);

        //创建菜单
        for (int i = 0; i < jmits.length; i++) {
            jmits[i] = new JMenuItem(jmitsname[i]);
            //改变字体颜色
            jmits[i].setForeground(Color.red);
            jmits[i].setFont(new Font("雅黑", Font.BOLD, 20));
            jmb.add(jmits[i]);
        }

        //菜单项创建监听
        for (int i = 0; i < jmits.length; i++) {
            jmits[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == jmits[0]) {
                        new BorrowSwing();
                    }
                    if (e.getSource() == jmits[1]) {
                        new returnSwing();
                    }
                    if (e.getSource() == jmits[2]) {
                        new chaxunSwing();
                    }
                    if (e.getSource() == jmits[3]) {
                        new printSwing();
                    }

                }
            });
        }

        jf.setJMenuBar(jmb);



        /* //借阅按钮
        JButton jb =new JButton("图书借阅");
        jb.setBounds(220,400,200,50);
         jb.setFont(new Font("宋体",Font.PLAIN,20));   //设置字体大小
         jb.setForeground(Color.red);    //背景颜色
         //归还按钮
         JButton jb1 =new JButton("图书归还");
         jb1.setBounds(220,500,200,50);
         jb1.setForeground(Color.red);    //背景颜色
         jb1.setFont(new Font("宋体",Font.PLAIN,20));   //设置字体大小

         JButton jb2 =new JButton("查询图书");
         jb2.setBounds(220,600,200,50);
         jb2.setForeground(Color.red);    //背景颜色
         jb2.setFont(new Font("宋体",Font.PLAIN,20));   //设置字体大小
         //查询按钮
         jb2.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 new chaxunSwing();
             }
         });

         //图书借阅
         jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                new BorrowSwing();
                }
            });

         //图书归还
         jb1.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
            new returnSwing();
             }
         });*/

       /* c.add(jb2);

         c.add(jb1);
        c.add(jb);*/
        c.add(jl2);
        c.add(jl);
        c.add(jl1);
    }


}
