package book.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/*管理员主界面
 * 1 添加图书
 * 2 删除图书*/

public class adminSwing {
    JFileChooser jlf;
    private JFrame jf = new JFrame("管理员窗口");
    private Container c = jf.getContentPane();

    //管理员主界面
    adminSwing() {
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
        jl.setText("欢迎管理员使用图书管理系统");
        Font f = new Font("宋体", Font.PLAIN, 30);
        jl.setFont(f);      //字体样式font
        jl.setForeground(Color.blue);
        jl.setBounds(150, 50, 600, 100);

        //添加按钮
        JButton jb = new JButton("添加图书");
        jb.setBounds(250, 200, 200, 50);
        jb.setFont(new Font("宋体", Font.PLAIN, 20));   //设置字体大小
        jb.setForeground(Color.red);    //背景颜色
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //添加图书界面
                new addSwing();
            }
        });

        //删除
        JButton jb1 = new JButton("删除图书");
        jb1.setBounds(250, 350, 200, 50);
        jb1.setFont(new Font("宋体", Font.PLAIN, 20));   //设置字体大小
        jb1.setForeground(Color.red);    //背景颜色
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //删除图书
                new removeSwing();
            }
        });

        //查询学生编号
        JButton jb2 = new JButton("导出数据库");
        jb2.setBounds(250, 500, 200, 50);
        jb2.setFont(new Font("宋体", Font.PLAIN, 20));   //设置字体大小
        jb2.setForeground(Color.red);    //背景颜色
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               jlf =new JFileChooser();
                int i = jlf.showSaveDialog(null);
                //关闭选择器
                if (i ==JFileChooser.CANCEL_OPTION){
                    JOptionPane.showMessageDialog(null,"选择器已经关闭");
                }
                //选择文件
                if (i==JFileChooser.APPROVE_OPTION){
                    String s =jlf.getSelectedFile().getPath()+".sql";
                    daochu(s);
                }
            }
        });



        c.add(jb2);
        c.add(jb1);
        c.add(jb);
        c.add(jl);
    }
    void daochu(String panch){
        //数据库导出
        String user = "root"; // 数据库帐号
        String password = "123456"; // 登陆密码
        String database = "user"; // 需要备份的数据库名
        String stmt1 = "mysqldump " + database + " -u " + user + " -p" + password + " >" + panch;
        String[] cmd = { "cmd", "/c", stmt1 };
        try {
            Runtime.getRuntime().exec(stmt1);
            Runtime.getRuntime().exec(cmd);
            JOptionPane.showMessageDialog(null,"数据导入到了："+panch+"中");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
