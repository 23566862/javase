package book.src;

import sun.dc.pr.PRError;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/*
 *   界面设计
 *   1 表格 获取数据库book表里的数据，二维数组接收所有数据，arr数组接收图书编号
 *   2 删除按钮
 *       2.1先判断文本框输入内容是否与arr数组的图书编号匹配，true ：执行sql删除语句，并且删除表格当前删除行数
 *   */
public class removeSwing {
    private String[] arr = null;  //存放idbook
    private JTable jt = null;
    private DefaultTableModel dfm = null;
    private String[][] dbdate = null;//表格元素
    final String[] ob = {"图书编号", "书名", "价格", "页数", "出版日期", "出版社"}; //表头名称
    //book表里的字段
    final String[] name = {"bookid", "bookname", "price", "bknumber", "riqi", "press"};  //方便查找BookCallss类里的数据
    private JFrame jf = new JFrame("删除图书窗口");
    private Container c = jf.getContentPane();
    private Connection co = null;
    private Statement st = null;
    private ResultSet rs = null;

    removeSwing() {
        jf.setBounds(400, 200, 700, 800);
        jf.setResizable(false); //窗口固定
        jf.getContentPane().setBackground(Color.pink);  //设置布局颜色
        c.setLayout(null);
        swing();

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    void swing() {
        //标题
        JLabel jLabel = new JLabel("图书管理员系统删除界面");
        Font f = new Font("宋体", Font.PLAIN, 30);
        jLabel.setFont(f);      //字体样式font
        jLabel.setForeground(Color.blue);   //改变字体颜色
        jLabel.setBounds(200, 50, 400, 40);

        JLabel jl1 = new JLabel("图书编号删除");
        jl1.setBounds(200, 110, 200, 30);
        jl1.setFont(new Font("宋体", Font.BOLD, 20));
        jl1.setForeground(Color.red);
        //修改文本框
        JTextField jtext = new JTextField();
        jtext.setBounds(330, 110, 200, 30);

        //删除按钮
        JButton jb = new JButton("删除图书");
        jb.setBounds(220, 170, 100, 30);
        //刷新
        JButton jb1 = new JButton("刷新");
        jb1.setBounds(420, 170, 100, 30);

        //查询所有数据
        selectMysql();

        //表格
        dfm = new DefaultTableModel(dbdate, ob);    //表格模型
        jt = new JTable(dfm);
        jt.setRowHeight(40);
        jt.setEnabled(false);   //不可修改表格数据
      /*  jt.setSelectionBackground(Color.red);   //设置选中背景色为红色
        jt.setSelectionForeground(Color.red);*/
        //面板
        JScrollPane js = new JScrollPane(jt);
        js.setBounds(70, 230, 600, 400);

        //按钮事件
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //判断文本框内容和图书编号是否匹配
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].equals(jtext.getText().trim())) {
                        removeMysql(jtext.getText().trim());
                        JOptionPane.showMessageDialog(null, "删除成功!");
                        dfm.removeRow(i);
                        dfm.fireTableDataChanged();
                        break;
                    }

                    //判断最后一次是否匹配
                    if (i == arr.length - 1) {
                        JOptionPane.showMessageDialog(null, "图书编号不存在");
                        break;
                    }
                }

            }
        });

        //表格刷新
        /*实现功能当其他界面界面删除数据或添加数据，可以直接刷新,无需退出
         * 实现思路
         * 1 给表格模块更新数据
         *  */
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //重新获取 bddate二维数组
                selectMysql();
                //更新
                dfm = new DefaultTableModel(dbdate, ob);
                jt.setModel(dfm);

            }
        });

        c.add(jb1);
        c.add(jb);
        c.add(jl1);
        c.add(jtext);
        c.add(jLabel);
        c.add(js);

    }

    //查询book表里的所有数据
    void selectMysql() {
        try {
            int i = 0;
            co = DriverManager.getConnection("jdbc:mysql://localhost/user?useSSL=false&serverTimezone=UTC", "root", "123456");

            st = co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            /* ResultSet.TYPE_SCROLL_INSENSITIVE,
           ResultSet.CONCUR_READ_ONLY
           设置可以返回ResultSet结果集行数
           注：第一个参数：

  ResultSet.TYPE_FORWARD_ONLY：不滚动结果集；
  ResultSet.TYPE_SCROLL_INSENSITIVE：滚动结果集，但结果集数据不会再跟随数据库而变化；

  ResultSet.TYPE_SCROLL_SENSITIVE：滚动结果集，但结果集数据不会再跟随数据库而变化；

第二个参数：

  CONCUR_READ_ONLY：结果集是只读的，不能通过修改结果集而反向影响数据库；

  CONCUR_UPDATABLE：结果集是可更新的，对结果集的更新可以反向影响数据库*/
            rs = st.executeQuery("select  * from  book");
            //实例化表格里的二维数组，行：结果集的行数，列数：为固定6
            rs.last();  //回到结果集结尾，获取结果集个数
            dbdate = new String[rs.getRow()][6];
            arr = new String[rs.getRow()];   //实例化bookid数组
            //resultSet.beforeFirst();   重新执行到第一行的前一行，以便查询结果集的集体内容
            rs.beforeFirst();
            while (rs.next()) {
                arr[i] = rs.getString("bookid");
                for (int j = 0; j < 6; j++) {
                    dbdate[i][j] = rs.getString(name[j]);
                    if (j == 2 || j == 3) {
                        dbdate[i][j] = Integer.toString(rs.getInt(name[j]));
                    }
                }
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //根据id删除字段
    void removeMysql(String id) {
        /* delete from 表名 where 条件
        实例：
        use db1
        delete from tb1 where id = 1;*/
        try {
            /*如果你的SQL 语句是诸如update,insert的更新语句，
            应该用statement的execute()方法*/
            st.execute("delete from book where bookid='" + id + "'");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
