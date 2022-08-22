package Text;

import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class 数据库数据到表格 {
    private Connection co=null;
    private Statement st=null;
    private ResultSet rs=null;
    private JFrame jf=new JFrame();
    private  Container c =jf.getContentPane();
    Vector rowdate,colunnames,hang;
    final String[] ob = {"图书编号", "书名", "价格", "页数", "出版日期", "出版社"}; //表头名称
    final String[] name = {"bookid", "bookname", "price", "bknumber", "riqi", "press"};  //方便查找BookCallss类里的数据
    public 数据库数据到表格(){
        jf.setBounds(300,40,600,500);
        jf.setLayout(null);


        try {
            co = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "123456");
            st=co.createStatement();
            rs=st.executeQuery("select * from book");
            rowdate =new Vector();

            while(rs.next()){
                 Vector hang =new Vector();
                for (int i = 0; i <name.length ; i++) {

                    hang.add(rs.getString(name[i]));
                }
                rowdate.add(hang);
            }

            colunnames =new Vector();
            for (int i = 0; i <ob.length ; i++) {
                colunnames.add(ob[i]);
            }

            for (int i = 0; i <colunnames.size() ; i++) {
                System.out.println(colunnames.get(i));
            }
            DefaultTableModel dfm =new DefaultTableModel(rowdate,colunnames);
            JTable jt=new JTable(dfm);
            jt.setBounds(100,100,400,200);
            jt.setRowHeight(40);
            JScrollPane js =new JScrollPane(jt);
            js.setBounds(100,100,400,300);
            c.add(js);



        } catch (SQLException e) {
            e.printStackTrace();
        }

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
    new 数据库数据到表格();
    }
}
