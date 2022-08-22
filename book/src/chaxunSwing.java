package book.src;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Handler;
/*界面设计
* 1 下拉框  数据来源数据库press字段，使用数组接收，并且创建下拉框组件
* 2 查询按钮监听  根据当前下拉框选择的文本查询数据库对应的数据存进二维数组，创建表格*/

//查询界面
public class chaxunSwing {
    JLabel jl =new JLabel();    //图片标签
    private String [] icon ={"book\\src/jpg/c.jpg","book\\src/jpg/jixie.jpg"};  //图片路径数组
    private String[] arr = new String[100]; //下拉列表框数据，来源数据库
    final String[] ob = {"图书编号", "书名", "价格", "页数", "出版日期", "出版社"}; //表头名称
    final String[] name = {"bookid", "bookname", "price", "bknumber", "riqi", "press"};  //方便查找BookCallss类里的数据
    private String[][] obdate = null;  //表格元素数组
    private Connection co = null; //获取连接
    private Statement st = null; //发送sql语句
    private ResultSet rs = null;//放回处理结果
    private JFrame jf = new JFrame("欢迎来到图书管理系统");
    private Container c = jf.getContentPane();

    public chaxunSwing() {
        jf.setBounds(400, 200, 700, 800);
        jf.setResizable(false); //窗口固定
        jf.getContentPane().setBackground(Color.pink);  //设置布局颜色
        c.setLayout(null);

        mysql();
        swing();

        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
    }

    //接收book库里的所有数据放进数组里
    void mysql() {

        try {
            co = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC", "root", "123456");
            st = co.createStatement();
            rs = st.executeQuery("select * from book");
            //把结果集放进集合类里
           int i =0;
            while (rs.next()) {
                /*BookClass b = new BookClass(rs.getString("bookid").trim(), rs.getString("bookname").trim(), rs.getInt("price"), rs.getInt("bknumber"), rs.getString("date").trim(), rs.getString("press").trim());
                al.add(b);*/
                arr[i] =rs.getString("press");
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    void swing() {
/*
        //数组接收图书出版社
        for (int i = 0; i < al.size(); i++) {
            arr[i] = al.get(i).getPress();
        }*/
        //标题
        JLabel jLabel = new JLabel("图书管理系统查询界面");
        Font f = new Font("宋体", Font.PLAIN, 30);
        jLabel.setFont(f);      //字体样式font
        jLabel.setForeground(Color.blue);   //改变字体颜色
        jLabel.setBounds(200, 50, 300, 40);
        //下拉框
        JComboBox<String> jc = new JComboBox<String>(arr);   //下拉列表框
        jc.setBounds(200, 200, 200, 40);
        //查询按钮
        JButton jb = new JButton("查询");
        jb.setBounds(420, 200, 100, 40);
        //图片标签

        jl.setBounds(50,50,140,140);
        //监听按钮
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String press =(String) jc.getSelectedItem();    //获取当前下拉框的出版社
                // mysql1();
                try {
                    PreparedStatement ps = co.prepareStatement("select  * from book where press=?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    ps.setString(1, (String) jc.getSelectedItem()); //当前下拉框选择的出版社
                    rs = ps.executeQuery(  );
                    //
                    rs.last();
                    obdate = new String[rs.getRow()][6];  //行数为结果集的int，列数为表列数
                   String obdate1 [][] =new String[rs.getRow()][6];
                    // rs.first();
                    rs.beforeFirst();
                    int count = 0;
                    while (rs.next()) {
                        for (int j = 0; j < 6; j++) {
                            obdate[count][j] = rs.getString(name[j]).trim();   //往表格里存入元素
                            //book表里有两个int值
                            if (j == 2 || j == 3) {
                                obdate[count][j] = String.valueOf(rs.getInt(name[j])).trim();
                            }
                        }
                        count++;
                    }

                    //创建表格
                    DefaultTableModel dmf =new DefaultTableModel(obdate,ob);
                    JTable jt = new JTable(dmf);
                    //设置表格行高
                    jt.setRowHeight(40) ;
                   /* DefaultTableCellRenderer dr =new DefaultTableCellRenderer();
                    dr.setHorizontalAlignment(JLabel.CENTER);*/
                    JScrollPane js = new JScrollPane(jt);   //表格放进面板
                    js.setBounds(50, 300, 600, 400);


                    //创建图片标签
                    int idex =0;
                    for (int i = 0; i <arr.length ; i++) {
                        //jc.getSelectedItem() 下拉列表框第几个元素
                        if(arr[i] == jc.getSelectedItem()){
                             idex =i;
                        }
                    }


                    //jl.setIcon(new ImageIcon(icon[idex]));

                    jf.add(js);

                } catch (SQLException s) {
                    s.printStackTrace();
                }
            }

        });

        jf.add(jb);
        jf.add(jc);
        jf.add(jLabel);
        jf.add(jl);
    }

    public static void main(String[] args) {
        new chaxunSwing();
    }


}
