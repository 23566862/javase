package book.src;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BorrowSwing {
    /*
    * 思路
    * 1 界面设计
    * 2个标签   登入姓名  学生证
    * 表格  当前图书馆里的所有图书
    * 按钮  借阅
    *
    * 2 实现逻辑
    * 标签数据来源登入界面的静态变量 id和name
    * 表格数据  sql语句查询库里数据放进二维数组
    * 创建表格选择器 用于查看当前选择的行数，获取当前行数的数据，用于插入到借阅表
    * 借阅按钮 sql语句在借阅表添加数据
    * */


    //借阅界面
    Font f = new Font("宋体", Font.PLAIN, 30);    //字体
    int i;  //表格当前行数
    Connection co =null;
    Statement st =null;
    ResultSet rs =null;
    String [] jieyue=new String[5];
    final String[] name = {"bookid", "bookname", "price", "bknumber", "riqi", "press"};  //方便查找BookCallss类里的数据
    final String[] ob = {"图书编号", "书名", "价格", "页数", "出版日期", "出版社"}; //表头名称
    private JFrame jf =new JFrame("学生窗口");
    private Container c =jf.getContentPane();
    private String [][] dbdate=null;
    JTable jtable =null;

    //文本框
    JTextField jt =new JTextField();


    public BorrowSwing(){
        jf.setBounds(400, 200, 700, 800);
        jf.setResizable(false); //窗口固定
        jf.getContentPane().setBackground(Color.pink);  //设置布局颜色
        c.setLayout(null);
        swing();

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    void swing(){
        Selectmysql();
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

        //创建表格和面板
        DefaultTableModel dmf =new DefaultTableModel(dbdate,ob);
        jtable=new JTable(dmf);
        jtable.setRowHeight(40);    //行高
        jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);   //只能选择一行

        //表格选择器
        ListSelectionModel limoed =jtable.getSelectionModel();
        limoed.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //获取当前表格选择行数
                i = jtable.getSelectedRow();
                //获取当前选择行数数据
                //表格i行0列数据
                jieyue[0]=(String)jtable.getValueAt(i,0);
                //表格i行1列数据
                jieyue[1]=(String)jtable.getValueAt(i,1);
                //学生id
                jieyue[2]=loingView.idcard;
                //学生姓名
                jieyue[3]=loingView.name;
                //当前日期
                Date da =new Date();
                SimpleDateFormat si =new SimpleDateFormat("yyyy-MM-dd");
                jieyue[4] =si.format(da);

            }
        });

        //面板
        JScrollPane js =new JScrollPane(jtable);
        js.setBounds(60,200,600,400);


        JButton jb1 =new JButton("借阅");
        jb1.setBounds(330,80,100,60);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = JOptionPane.showConfirmDialog(null, "是否借阅？", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (i==JOptionPane.YES_OPTION){
                    boolean b = insertMysql(jieyue[0],jieyue[1],Integer.valueOf(jieyue[2]),jieyue[3],jieyue[4]);
                    if (b){
                        JOptionPane.showMessageDialog(null,"借阅成功！");
                    }
                } else if(i == JOptionPane.NO_OPTION){
                    JOptionPane.showMessageDialog(null,"你已取消借阅");
                }

            }
        });



        c.add(jl1);
        c.add(jl2);
        c.add(js);
        c.add(jb1);
        c.add(jt);


    }
    
   void Selectmysql(){
        try {
            co= DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC", "root", "123456");
            st =co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs =st.executeQuery("select * from book ");
            rs.last();
            dbdate =new String[rs.getRow()][6];
               //回到第一行数据
               rs.beforeFirst();
               int count =0;
               while(rs.next()){
                   for (int i = 0; i <6 ; i++) {
                       dbdate[count][i]=rs.getString(name[i]);
                       if (i== 2 || i == 3){
                           dbdate[count][i] = String.valueOf(rs.getInt(name[i])).trim();
                       }
                   }
                   count++;
                   }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    boolean insertMysql(String bookid,String bookname,int id,String name,String date){
        boolean b =false;
        try {
            co =DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC", "root", "123456");
            st=co.createStatement();
            st.executeUpdate("insert into jieyue(bookid,bookname,id,usname,riqi,zhuangtai)values ('"+bookid+"','"+bookname+"','"+id+"','"+name+"','"+date+"',1)");
            b=true;
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"图书已被借出");
           e.printStackTrace();
        }
        return b;
    }

}
