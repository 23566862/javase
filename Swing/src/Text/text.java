package Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class text {
    private Connection c=null;
    private Statement st=null;
    private ResultSet rs=null;
    private String [] ob ={"学生","姓名"};
    private JFrame jf=new JFrame();
    private Container co =jf.getContentPane();  //创建容器
    //创建无参构造方法
    public text(){
        jf.setBounds(400,200,700,800);  //
        jf.setResizable(false); //设置窗口大小不可改变
        co.setLayout(null); //设置布局
         swing();   //自定义一个方法
        jf.setVisible(true);    //窗口可以显示
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //
    }
    void swing(){
        JLabel jl =new JLabel("借阅证管理");
        jl.setBounds(320,20,200,40);
        jl.setFont(new Font("宋体",Font.BOLD,30));
        JTextField jt =new JTextField();

        JButton jb =new JButton("");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector vc =mysql();
               // JTable tab =new JTable(ob,vc);
            }
        });

        co.add(jl);
    }

    Vector mysql(){
        Vector data =new Vector();

        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","123456");
            st=c.createStatement();
            rs=st.executeQuery("select * from stid");
           /* while(rs.next()){
                //rs.next() 判断结果集是否为空
                Vector rowdata =new Vector();   //接收一行数据
                for (int i = 0; i <ziduan.length ; i++) {
                    //rs.getString("id");
                  rowdata.add(rs.getString(ziduan[i]));
                }
                data.add(rowdata);
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void main(String[] args) {
        new text();
    }
}
