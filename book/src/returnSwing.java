package book.src;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/*
* 思路
*
* 1 界面的设计
* 表格  存放当前登入学生借阅的图书
* 标签  当前登入学生的name和id
* 按钮  归还图书
*
* 2 实现逻辑
* 表格数据  来源图书借阅表，条件查询 条件：当前学生id的数据  如果没有数据false(提示没有借阅！)
* 表格设置监听  获取当前选择的表格行数 idex  和当前表格选择行数的第一列id
* 归还按钮  执行sql语句删除 删除当前表格选中的行数 ，删除条件 获取的id
*
* */
public class returnSwing {
    //存储当前选择的表格下标
    int idex=0;
    Font f = new Font("宋体", Font.PLAIN, 30);    //字体
    Connection co =null;
    Statement st =null;
    ResultSet rs =null;
    String [] ob ={"图书编号", "书名", "学号", "姓名", "日期", "接书状态"};
    String [][] dbdate;
    String [] ziduan ={"bookid","bookname","id","usname","riqi","zhuangtai"};
    private JFrame jf =new JFrame("学生窗口");
    private JScrollPane js;
    private Container c =jf.getContentPane();
    public returnSwing(){
        jf.setBounds(400, 200, 700, 800);
        jf.setResizable(false); //窗口固定
        jf.getContentPane().setBackground(Color.pink);  //设置布局颜色
        c.setLayout(null);

        swing();

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    void swing(){
        boolean b =Selectmysql(loingView.name);
        //创建表格
            DefaultTableModel dfm =new DefaultTableModel(dbdate,ob);
            JTable jt =new JTable(dfm);
            jt.setRowHeight(40);
            js =new JScrollPane(jt);
            js.setBounds(50,250,600,400);

            //表格选择器
        ListSelectionModel lsm =jt.getSelectionModel();
        lsm.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //选择行数
                idex =jt.getSelectedRow();
            }
        });

        //标签
        JLabel jl1 =new JLabel();
        jl1.setText("姓名："+loingView.name);
        jl1.setBounds(40,30,600,100);
        jl1.setFont(f);
        jl1.setForeground(Color.red);
        //id
        JLabel jl2 =new JLabel();
        jl2.setText("借阅证："+loingView.idcard);

        jl2.setBounds(40,80,600,100);
        jl2.setFont(f);
        jl2.setForeground(Color.red);
        //创建按钮
        JButton jb =new JButton("归还图书");
        jb.setBounds(340,80,100,50);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取当前行数的id，sql语句删除
                boolean b = removemysql((String) jt.getValueAt(idex,0));
                if (b){
                    JOptionPane.showMessageDialog(null,"归还成功");
                    dfm.removeRow(idex);
                }

            }
        });
        if (!b){
            JOptionPane.showMessageDialog(null,"你当前没有借阅图书");
        }

        c.add(jb);
        c.add(js);
        c.add(jl1);
        c.add(jl2);
    }
    //获取当前姓名对应的数据
      boolean Selectmysql(String usname){
        boolean b =false;
        try {
            co= DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC", "root", "123456");
            PreparedStatement pst=co.prepareStatement("select * from jieyue where usname=?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            pst.setString(1,usname);
            rs=pst.executeQuery();
            //判断是否有数据
            if (rs.next()){
                rs.last();
                dbdate=new String[rs.getRow()][6];
                rs.beforeFirst();
                int count =0;
                while(rs.next()){
                    for (int i = 0; i <6 ; i++) {
                        dbdate[count][i]=rs.getString(ziduan[i].trim());
                        if (i==2 || i==5){
                            dbdate[count][i]=String.valueOf(rs.getString(ziduan[i]));
                        }
                    }
                    count++;
                }
                b=true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    //删除借阅图书msql
    boolean removemysql(String id){
        boolean b =false;
        try {
            st=co.createStatement();
            st.execute("delete from jieyue where bookid='"+id+"'");
            b=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }


}
