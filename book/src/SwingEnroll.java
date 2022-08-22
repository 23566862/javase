package book.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.*;
import java.util.Random;

/*思路
 * 1 界面的设计
 * 2 监听两个单选按钮 id=1 学生注册 id=2管理员注册
 * 3 监听注册按钮
 *   3.1 密码框组件先拼 比较两次密码是否相同  true 使用sql语句添加数据 false 提示*/
//注册界面
public class SwingEnroll {
    int id = 1;
    private JFrame jf = new JFrame("注册窗口");
    private Container c = jf.getContentPane();
    private JLabel[] jTables = new JLabel[5];
    private JTextField[] jt = new JTextField[2];
    private String[] jlablename = {"姓名：", "账号：", "密码：", "确认密码：", "注册人员："};
    private JLabel[] jlabes1 = new JLabel[3];
    private String[] jlname = {"入学年份:", "专业号:", "班级号:"};
    private String[] year = {"2015", "2016", "2017", "2018", "2019", "2020", "2021"};//入学年份
    private String[] zhuanye = {"01软件技术", "02云计算", "03数控", "04幼教", "05大数据", "06土木工程"};//专业号
    private String[] banji = {"01", "02", "03", "04", "05", "06"};//班级号


    private JPasswordField ps = new JPasswordField();    //密码框
    private JPasswordField ps1 = new JPasswordField();    //密码框

    SwingEnroll() {
        jf.setBounds(400, 200, 700, 800);
        jf.setResizable(false); //窗口固定
        jf.getContentPane().setBackground(Color.pink);  //设置布局颜色
        c.setLayout(null);

        swing();

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);  //关闭子窗口父窗口不关闭
    }

    void swing() {
        JLabel jLabel = new JLabel("图书管理系统注册界面");
        Font f = new Font("宋体", Font.PLAIN, 30);
        jLabel.setFont(f);
        jLabel.setBounds(230, 60, 300, 40);
        jLabel.setForeground(Color.blue);

        //循环创建标签
        int x = 100;
        for (int i = 0; i < jTables.length; i++) {
            jTables[i] = new JLabel(jlablename[i]);
            jTables[i].setBounds(180, 50 + x, 200, 40);
            x += 60;
            c.add(jTables[i]);
        }
        //循环创建文本框
        int y = 100;
        for (int i = 0; i < jt.length; i++) {
            jt[i] = new JTextField();
            jt[i].setBounds(250, 50 + y, 300, 30);
            y += 60;
            c.add(jt[i]);
            jt[i].setFont(new Font("宋体", Font.BOLD, 15));
        }

        //两个密码框
        ps.setBounds(250, 280, 300, 30);
        ps1.setBounds(250, 330, 300, 30);


        //单选按钮
        JRadioButton jr = new JRadioButton("学生注册");
        jr.setBounds(250, 390, 100, 30);
        JRadioButton jr1 = new JRadioButton("管理人员注册");
        jr1.setBounds(370, 390, 150, 30);
        ButtonGroup bg = new ButtonGroup();   //设置只能选中一个按钮
        jr.setSelected(true);   //默认选择第一个
        bg.add(jr);
        bg.add(jr1);

        int y1 = 30;
        for (int i = 0; i < jlabes1.length; i++) {
            jlabes1[i] = new JLabel(jlname[i]);
            jlabes1[i].setBounds(40 + y1, 500, 150, 30);
            y1 += 180;
            jlabes1[i].setFont(new Font("宋体", Font.BOLD, 15));
            jf.add(jlabes1[i]);
        }
        //下拉列表框，用于学号注册
        JComboBox<String> jc = new JComboBox<>(year);
        jc.setBounds(160, 500, 80, 30);
        JComboBox<String> jc1 = new JComboBox<>(zhuanye);
        jc1.setBounds(310, 500, 90, 30);
        JComboBox<String> jc2 = new JComboBox<>(banji);
        jc2.setBounds(500, 500, 80, 30);

        c.add(jc);
        c.add(jc1);
        c.add(jc2);

        //监听单选按钮为学生登入
        jr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jr.isSelected()) {
                    id = 1;
                }
            }
        });

        ////监听单选按钮为管理员登入
        jr1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jr1.isSelected()) {
                    id = 2;
                }
            }
        });

        //给借阅证文本框设置焦点监听
        jt[1].addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                jt[1].setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                boolean b = isidCard(jt[1]);
                if (b && jt[1].getText().length() > 5) {
                    jt[1].setForeground(Color.BLACK);
                } else {
                    jt[1].setText("不符合条件");
                    jt[1].setForeground(Color.red);

                }
            }
        });

        //注册按钮
        JButton jb = new JButton("注册");
        jb.setBounds(290, 640, 100, 40);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //判断全部文本框是否为空，id是否为纯数字
                if (isnoll(jt) && isidCard(jt[1])) {
                    //两次密码是否相等
                            if (string(ps.getPassword()).equals(string(ps1.getPassword()))) {
                                //获取下拉框全部组成的学生学号
                                String s1 = (String) jc1.getSelectedItem();
                                //序号为随机数
                        Random ra = new Random();
                        String idcard = jc.getSelectedItem() + s1.substring(0, 2) + jc2.getSelectedItem() + ra.nextInt(100);
                        //数据库注册
                        mysql(jt[1].getText().trim(), string(ps.getPassword()), jt[0].getText(), idcard);
                        JOptionPane.showMessageDialog(null, "注册成功");
                        System.out.println(jt[1]+" "+jt[0].getText()+" "+idcard);
                    } else {
                        JOptionPane.showMessageDialog(null, "两次密码不一致", "信息", 0);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "文本框内容为空或格式错误", "信息", 0);
                }
            }
        });

        c.add(jb);
        c.add(jr);
        c.add(jr1);
        c.add(jLabel);
        c.add(ps);
        c.add(ps1);

    }


    //密码框char转String
    String string(char[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    //mysql插入注册数据
    boolean mysql(String zhanghao, String psword, String usname, String idcard) {
        boolean b = false;
        try {
            Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC", "root", "123456");
            Statement st = co.createStatement();
            //数据添加进登入用户表 us
            st.executeUpdate("insert into us(zhanghao,psword,id,usname,idcard)values ('" + zhanghao + "','" + psword + "','" + id + "','" + usname + "','" + idcard + "')");
            //注册借阅证，借阅证表 suid表
            st.executeUpdate("insert into stid(id,usname)values ('" + Integer.valueOf(idcard) + "','" + usname + "')");
            b = true;
        } catch (SQLException e) {

            //账号重复
            JOptionPane.showMessageDialog(null, "账号已存在");
        }
        return b;
    }


    //是否为纯数字
    boolean isidCard(JTextField jt) {
        boolean b = false;
        if (jt.getText().trim().matches("[0-9]+")) {
            b = true;
        }
        return b;
    }

    //文本框是否为空
    boolean isnoll(JTextField[] jt) {
        boolean b = true;
        //文本框为空返回false
        for (int i = 0; i < jt.length; i++) {
            if (jt[i].getText().isEmpty()) {
                b = false;
                break;
            }
        }
        //两个密码框内容为空返回false
        if (string(ps.getPassword()).isEmpty() || string(ps1.getPassword()).isEmpty()) {
            b = false;
        }

        return b;
    }




}
