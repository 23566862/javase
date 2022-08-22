package book.src;

import sun.dc.pr.PRError;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/*1 界面设计
 *  1.1 for循环创建标签和文本框组件
 * 2 文本框的设置
 *   2.1 文本框设置提示输入格式文本
 *   2.2 文本框设置监听焦点
 *       获得焦点文本内容设置为空
 *       失去焦点 内容为空设置文本提示，字体改为红
 *               不为空 （价格，页数，日期需要判断 false：设置文本提示，字体改为红） 改回字体颜色
 *  3 添加按钮
 *  3.1 再次判断文本框是否为空和符合条件
 *       true 获取文本框数据使用sql语句添加
 *       false：提示
 * 4 取消按钮 文本框内容设置为空*/

//添加图书界面
public class addSwing {

    //final String[] name = {"bookid", "bookname", "price", "bknumber", "date", "press"}; //表里的属性
    private Font f = new Font("宋体", Font.BOLD, 15);
    private String[] name = {"图书编号", "书  名", "价   格", "页  数", "日   期", "出版社"};   //标签数组文本
    private Statement st = null;
    private Connection co = null;
    private JTextField jt[] = new JTextField[6];    //文本框数组
    private JRadioButton jrb[] = new JRadioButton[5];   //单选按钮数组
    private String radioname[] = {"计算机类", "机械类", "经济类", "能源类", "文学类"};//单选按钮文本
    private String text[] = {"TP", "TU", "FE", "XR", "IR"}; //文本
    private ButtonGroup bg = new ButtonGroup();
    private JButton jb = new JButton("添加");  //添加按钮
    private JFrame jf = new JFrame("添加图书窗口");
    private Container c = jf.getContentPane();
    private Font font = new Font("宋体", Font.BOLD, 15);
    private int idex; //监听按钮索引

    public addSwing() {
        jf.setBounds(400, 200, 700, 800);
        jf.setResizable(false); //窗口固定
        jf.getContentPane().setBackground(Color.pink);  //设置布局颜色
        c.setLayout(null);
        swing();

        jf.setVisible(true);

        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    void swing() {

        //表头标签
        JLabel jLabel = new JLabel("录入图书");
        jLabel.setBounds(250, 20, 200, 100);
        jLabel.setFont(new Font("宋体", Font.BOLD, 40));
        jLabel.setForeground(Color.BLUE);
        c.add(jLabel);


        //使用for循环创建标签
        int num1 = 200;
        JLabel jl[] = new JLabel[6];
        for (int i = 0; i < jl.length; i++) {
            jl[i] = new JLabel(name[i]);
            jl[i].setFont(font);
            jl[i].setForeground(Color.red);
            if (i % 2 == 0) {
                jl[i].setBounds(100, num1, 200, 30);
            } else {
                jl[i].setBounds(400, num1, 200, 30);
                num1 += 100;
            }
            c.add(jl[i]);
        }

        //循环创建文本框
        //JTextField jt [] =new JTextField[6];
        int num = 200;
        for (int i = 0; i < jt.length; i++) {

            jt[i] = new JTextField();

            //利用循环添加位置
            if (i % 2 == 0) {
                jt[i].setBounds(170, num, 200, 30);
            } else {
                jt[i].setBounds(470, num, 200, 30);
                num += 100;
            }

            c.add(jt[i]);
            //改变初始字体
            jt[i].setFont(f);
        }

        //单选按钮
        int x = 100;
        for (int i = 0; i < jrb.length; i++) {
            jrb[i] = new JRadioButton(radioname[i]);
            jrb[i].setBounds(x, 150, 80, 30);
            c.add(jrb[i]);
            bg.add(jrb[i]);
            x += 100;
        }

        //默认选择第一个
        jrb[0].setSelected(true);
        //单选按钮设置监听

        for (int i = 0; i < jrb.length; i++) {
            int finalI = i;
            jrb[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //如果当前单选按钮被选中
                    if (jrb[finalI].isSelected()) {
                        idex = finalI;
                    }
                }
            });
        }

        //文本框提示信息
        tishitext();

        //文本框焦点监听
        for (int i = 0; i < jt.length; i++) {

            int finalI = i;
            jt[i].addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    //获得焦点设置文本为空
                    jt[finalI].setText("");
                    //System.out.println(finalI);
                }

                //失去焦点
                @Override
                public void focusLost(FocusEvent e) {
                    //失去焦点判断输入内容是否为空，为空则提示
                    if (jt[finalI].getText().equals("")) {
                        //System.out.println(finalI);
                        //JOptionPane.showMessageDialog(null,"内容不能为空");
                        jt[finalI].setText("不能为空");
                        jt[finalI].setForeground(Color.red);
                    } else {
                        boolean b = true;
                        if (finalI == 2 | finalI == 3) {
                            //如果不为空，则判断输入格式是否正确
                            b = isformat(jt[finalI]);
                            if (!b) {
                                //System.out.println(finalI);
                                //JOptionPane.showMessageDialog(null, "格式错误");
                                //输入错误文本框提示输入错误，并且改变字体颜色
                                jt[finalI].setText("请输入1-9的数");
                                jt[finalI].setForeground(Color.red);
                            } else {
                                //正确改回颜色
                                jt[finalI].setForeground(Color.BLACK);
                            }
                        }

                        //判断日期格式
                        if (finalI == 4) {
                            boolean b1 = isdate(jt[finalI].getText());
                            if (!b1) {
                                jt[finalI].setText("格式错误");
                                jt[finalI].setForeground(Color.red);
                            } else {
                                //正确改回颜色
                                jt[4].setForeground(Color.BLACK);
                            }
                        }

                        //不为空改回字体颜色
                       if (b) {
                            jt[finalI].setForeground(Color.black);
                        }

                    }

                }

            });

        }


        //取消 按钮
        jb.setBounds(400, 500, 100, 40);
        JButton jb1 = new JButton("取消");
        jb1.setBounds(150, 500, 100, 40);
        //监听取消，如果点击全部内容清空
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < jt.length; i++) {
                    //清除再次显示提示
                    tishitext();
                    jt[i].setText(null);
                }
            }
        });


        //添加图书到数据库

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //如果文本框全部为空或者,输入的内容不符合条件
                if (isnoll() | !isformat(jt[2]) | !isformat(jt[3]) | !isdate(jt[4].getText())) {
                    JOptionPane.showMessageDialog(null, "输入有误！");
                } else {
                    //输入的文本全部符合条件就存入数据库
                    boolean b = mysql(text[idex] + jt[0].getText().trim(), jt[1].getText().trim(), Integer.valueOf(jt[2].getText()), Integer.valueOf(jt[3].getText()), jt[4].getText().trim(), jt[5].getText().trim());
                    if (b) {
                        JOptionPane.showMessageDialog(null, "图书添加成功");
                    } else {
                        JOptionPane.showMessageDialog(null, "图书添加失败");
                    }

                }
            }
        });
        c.add(jb1);
        c.add(jb);

    }

    boolean mysql(String bookid, String bookname, int price, int bknumber, String date, String press) {
        boolean b = false;
        try {
            co = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC", "root", "123456");
            st = co.createStatement();
            st.executeUpdate("insert into book(bookid,bookname,price,bknumber,riqi,press)values ('" + bookid + "','" + bookname + "','" + price + "','" + bknumber + "','" + date + "','" + press + "')");
            b = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "添加失败");
            //e.printStackTrace();
        }
        return b;
    }

    //全部文本框是否为空
    boolean isnoll() {
        for (int i = 0; i < jt.length; i++) {
            if (jt[i].getText().isEmpty()) {
                return true;    //为空
            }
        }
            return false;   //不为空
        }

        //判断文本框内容是否符为整数
        boolean isformat(JTextField jt) {
            boolean b = true;
            //不是纯数字返回false
            if (!jt.getText().trim().matches("[0-9]+")) {
            b = false;
        }

        return b;
    }


    //文本提示
    void tishitext() {
        jt[2].setText("输入整数");
        jt[2].setFont(f);
        jt[2].setForeground(Color.gray);
        jt[3].setText("输入整数");
        jt[3].setForeground(Color.gray);
        jt[3].setFont(f);
        jt[4].setText("格式：xxxx-xx-xx");
        jt[4].setForeground(Color.gray);
        jt[4].setFont(f);
    }


    //判断日期是否正确
    boolean isdate(String s) {
        boolean b = true;
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            sdf2.parse(s);
        } catch (ParseException e) {
            b = false;
        }

        return b;
    }


    public static void main(String[] args) {


    }


}


