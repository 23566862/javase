package book.src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class stchanxunSwing {
    JTextField jtf,jtf1;
    Vector data,ob;
    private JFrame jf=new JFrame();
    private Container co =jf.getContentPane();
    private Connection c=null;
    private Statement st=null;
    private ResultSet rs=null;
    public stchanxunSwing(){
        jf.setBounds(400, 400, 700, 800);
        jf.setResizable(false); //窗口固定
        jf.getContentPane().setBackground(Color.pink);  //设置布局颜色
        co.setLayout(null);

        swing();

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);  //关闭子窗口父窗口不关闭
    }

    void swing(){
    JLabel jl =new JLabel("学生学号管理系统");
    jl.setFont(new Font("宋体",Font.BOLD,30));
    jl.setForeground(Color.blue);
    jl.setBounds(200,100,300,30);
    //标签
        JLabel jLabel =new JLabel("学号:");
        jLabel.setBounds(200,150,100,20);

        JLabel jLabel1 =new JLabel("姓名:");
        jLabel1.setBounds(200,220,100,20);

    //文本框
     jtf =new JTextField();
    jtf.setBounds(250,150,200,30);

         jtf1 =new JTextField();
        jtf1.setBounds(250,220,200,30);


        JButton jb =new JButton("修改");
        jb.setBounds(500,180,200,20);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if (!(jLabel.getText().equals("") && jLabel1.getText().equals(""))){
                if (isidCard(jtf)){

                }
            }
            }
        });

        //表头
         ob =new Vector();
        ob.add("学号");
        ob.add("姓名");
        //数据
       mysql();

       DefaultTableModel dmf =new DefaultTableModel(data,ob);
       JTable jt =new JTable(dmf);
        jt.setRowHeight(30);
        JScrollPane js =new JScrollPane(jt);
        js.setBounds(130,300,400,300);
        co.add(jb);
        co.add(jLabel);
        co.add(jLabel1);
        co.add(jtf1);
        co.add(jtf);
        co.add(js);
        co.add(jl);
    }
    //查询数据
    void mysql(){
         data =new Vector();
        try {
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC","root","123456");
            st=c.createStatement();
            rs=st.executeQuery("select * from stid");
            while(rs.next()){
                Vector rowdata =new Vector();
                rowdata.add(String.valueOf(rs.getString("id")));
                rowdata.add(rs.getString("usname"));
                data.add(rowdata);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //修改数据
    void mysqlUpdate(){
        try {
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC","root","123456");
            st=c.createStatement();
           st.executeUpdate("update stid set id='"+Integer.valueOf(jtf.getText())+"',usname='"+jtf1.getText()+"'");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    //是否为纯数字
    boolean isidCard(JTextField jt){
        boolean b =false;
        if (jt.getText().trim().matches("[0-9]+")){
            b =true;
        }
        return b;
    }
}
