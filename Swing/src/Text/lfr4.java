package Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class lfr4 {
    String [] [] data=null;
    String [] name =new String[]{" StuID","Name","BirthDate","Hobby"};
    Connection co=null;
    Statement st =null;
    ResultSet rs=null;
    int id=01;
    private JFrame jf = new JFrame();
    private Container c = jf.getContentPane();
    String [] arr =new String[]{"计算机系","经理系","机电系"};
    public lfr4(){
        jf.setBounds(400, 200, 700, 800);
        jf.setResizable(false); //窗口固定
        jf.getContentPane().setBackground(Color.pink);  //设置布局颜色
        c.setLayout(null);
        swing();

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    void swing(){
        JComboBox<String> jc =new JComboBox<>(arr);
        jc.setBounds(100,80,200,30);
        jc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jc.getSelectedItem().equals("计算机系")){
                    id=01;
                    //JTable jt =new JTable()
                }
                if (jc.getSelectedItem().equals("经理系")){
                    id=02;
                }
                if (jc.getSelectedItem().equals("机电系")){
                    id=03;
                }

            }
        });
        mysql(id);
        for (int i = 0; i <data.length ; i++) {
            for (int j = 0; j <4 ; j++) {
                System.out.println(data[i][j]);
            }
        }
        c.add(jc);
    }
    void mysql(int id){
        try {
            co= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfoadmin","root","123456");
            st=co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs=st.executeQuery("select * from studentinfo where StuID like %'"+id+"'%");
            rs.last();
            data=new String[rs.getRow()][4];
            rs.beforeFirst();
            int cont =0;
            while(rs.next()){
                for (int i = 0; i <name.length ; i++) {
                    data[cont][i]=rs.getString(name[i]);
                }
                cont++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
    new lfr4();
    }
}
