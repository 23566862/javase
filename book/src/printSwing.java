package book.src;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class printSwing {
    JFileChooser jfl;//文件选择器
    JScrollPane js;
    Connection co =null;
    ResultSet rs =null;
    String [][] dbdate;
    String [] ob ={"图书编号", "书名", "学号", "姓名", "日期", "接书状态"};
    String [] ziduan ={"bookid","bookname","id","usname","riqi","zhuangtai"};
    private JFrame jf =new JFrame("打印报表窗口");
    private Container c =jf.getContentPane();
    Font f = new Font("宋体", Font.PLAIN, 30);    //字体
    //打印报表界面
    public printSwing(){

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
            if (!b){
                JOptionPane.showMessageDialog(null,"当前没有借阅图书");
            }
        //标签
        JLabel jl1 =new JLabel();
        jl1.setText("姓名："+loingView.name);
        jl1.setBounds(230,30,600,100);
        jl1.setFont(f);
        jl1.setForeground(Color.red);
        //id
        JLabel jl2 =new JLabel();
        jl2.setText("借阅证："+loingView.idcard);

        jl2.setBounds(230,100,600,100);
        jl2.setFont(f);
        jl2.setForeground(Color.red);

        //表格模型运输传入为空值
        DefaultTableModel dfm =new DefaultTableModel(dbdate,ob);
        JTable jt =new JTable(dfm);
        jt.setRowHeight(40);
        jt.setEnabled(false);   //不可修改表格数据
        js =new JScrollPane(jt);
        js.setBounds(50,300,600,400);
        c.add(js);

        //按钮
        JButton jb =new JButton("打印报表生成excel表格");
        jb.setBounds(220,220,250,50);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (b){
                     jfl=new JFileChooser();
                    int i = jfl.showSaveDialog(null);
                    //关闭选择器
                    if (i ==JFileChooser.CANCEL_OPTION){
                        JOptionPane.showMessageDialog(null,"选择器已经关闭");
                    }
                    //选择文件
                    if (i==JFileChooser.APPROVE_OPTION){
                        String s =jfl.getSelectedFile().getPath()+".xls";
                       tableINexcel(dbdate,ob,s);
                    }


                }else{
                    JOptionPane.showMessageDialog(null,"当前没有借阅图书无法，打印报表！");
                }

            }
        });


            c.add(jb);
            c.add(jl1);
            c.add(jl2);



    }
    //获取当前姓名对应的数据
    boolean Selectmysql(String usname){
        boolean b =false;
        try {
            co= DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC", "root", "123456");
            PreparedStatement pst=co.prepareStatement("select * from jieyue where usname=?", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
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

    //表格数据写入excel
    void tableINexcel(String[][] data,String [] ob,String patch){
        Workbook book =new HSSFWorkbook();//创建工作破
        Sheet sheet = book.createSheet("借阅表");
        Row row = sheet.createRow(0);
        //创建excel表头
        for (int i = 0; i <ob.length ; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(ob[i]);
        }

        //excel数据
        int count =0;
        for (int i = 1; i <=data.length ; i++) {
            Row row1 = sheet.createRow(i);
            for (int j = 0; j <ob.length ; j++) {
                row1.createCell(j).setCellValue(data[count][j]);
            }
            count++;
        }

        try {
            FileOutputStream file =new FileOutputStream(patch);
            book.write(file);
            file.close();
            JOptionPane.showMessageDialog(null,"你打印的excel路径在："+patch);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
          e.printStackTrace();
        }


    }


}
