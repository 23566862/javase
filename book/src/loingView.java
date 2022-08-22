package book.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


/*
   大致思路
1 界面设计
    1.1 单选按钮的选择
    1.2 登入按钮和注册按钮
2 单选按钮选择 设置监听 id=1 学生登入 2 id = 管理员登入
3 监听登入按钮 sql预处理语句是否找到匹配，找到true:根据单选按钮登入不同界面
4 注册按钮 注册界面


* */
//登入界面
public class loingView {
    public static String name;
    public static String idcard;
    private static int id1 = 1;
    private JFrame jf = new JFrame("图书登入窗口");
    private Container c = jf.getContentPane();
    private JTextField jt = new JTextField();
    private JPasswordField ps = new JPasswordField();    //密码框

    loingView() {
        jf.setBounds(300, 200, 500, 400);
        jf.setResizable(false); //窗口固定
        jf.getContentPane().setBackground(Color.pink);
        c.setLayout(null);

        userloing();

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    //用户登入界面swing
    void userloing() {
        JLabel jLabel = new JLabel("图书管理系统界面");
        Font f = new Font("宋体", Font.PLAIN, 30);
        jLabel.setFont(f);
        jLabel.setBounds(140, 30, 300, 40);
        jLabel.setForeground(Color.blue);
        c.add(jLabel);
        //账号
        JLabel jl = new JLabel("账号:");
        jl.setBounds(120, 90, 200, 40);

        jt.setBounds(160, 90, 200, 30);


        //密码

        JLabel jl1 = new JLabel("密码:");
        jl1.setBounds(120, 150, 200, 30);

        ps.setBounds(160, 150, 200, 30);

        //单选按钮
        JRadioButton jr = new JRadioButton("学生登入");
        jr.setBounds(140, 200, 100, 20);

        JRadioButton jr1 = new JRadioButton("管理人员登入");
        jr1.setBounds(240, 200, 120, 20);
        ButtonGroup bg = new ButtonGroup();   //设置只能选中一个按钮
        jr.setSelected(true);   //默认选择第一个
        bg.add(jr);
        bg.add(jr1);

        //监听单选按钮为学生登入
        jr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jr.isSelected()) {
                    id1 = 1;
                }
            }
        });

        ////监听单选按钮为管理员登入
        jr1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jr1.isSelected()) {
                    id1 = 2;
                }
            }
        });
        enroll();   //注册按钮
        jbutton();  //登入按钮
        c.add(jr);
        c.add(jr1);
        c.add(jl);
        c.add(jt);
        c.add(jl1);
        c.add(ps);
    }


    //连接数据库验证数据是否正确
    boolean mysql(String zhanghao, String psword) {

        boolean b = false;
        try {
            Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC", "root", "123456");
            PreparedStatement pst = c1.prepareStatement("select * from us where zhanghao=? and psword =? and id=?");
            pst.setString(1, zhanghao);
            pst.setString(2, psword);
            pst.setInt(3, id1);
            ResultSet rs = pst.executeQuery();

            //如果有数据判断是什么人员登入
            while (rs.next()) {
                if (rs.getInt(3) == id1) {
                    name = rs.getString("usname");
                    idcard = rs.getString("idcard");
                    b = true;
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    //登入按钮监听
    void jbutton() {
        //登入按钮
        JButton jb = new JButton("登入");
        jb.setBounds(270, 260, 100, 30);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = null;
                StringBuffer sb = new StringBuffer();
                //密码框返回值为char类型，拼接成String
                for (int i = 0; i < ps.getPassword().length; i++) {
                    sb.append(ps.getPassword()[i]);
                    s = sb.toString();
                }

                //调用方法查看数据库是否有对应的数据
                boolean bo = mysql(jt.getText().trim(), s);

                if (bo) {
                    //登入成功判断id状态为什么登入
                    //JOptionPane.showMessageDialog(null, "登入成功");
                    if (id1 == 1) {
                        //学生登入
                        new stuSwing();
                        //new BorrowSwing();
                    }

                    if (id1 == 2) {
                        //管理员登入
                        new adminSwing();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "账号或密码错误");
                }
            }
        });
        c.add(jb);
    }

    //注册按钮
    void enroll() {
        JButton jb1 = new JButton("注册");
        jb1.setBounds(120, 260, 100, 30);
        c.add(jb1);

        //监听是否点击
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SwingEnroll();
            }
        });
    }

    public static void main(String[] args) {
        new loingView();
    }
}
