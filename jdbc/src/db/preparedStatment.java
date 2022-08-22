package db;

import java.sql.*;

public class preparedStatment {
    public preparedStatment(){
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","123456");
            String sql ="select * from stu where   sex =?";
            PreparedStatement p=c.prepareStatement(sql);
            p.setString(1,"男"); //预处理
            ResultSet rs =p.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(1) +rs.getString(2)+rs.getString(3)+rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    statics boolean mysql(String zhanghao,String psword,int id){
        String zh =null;
        String ps =null;
        int id1=1;
        boolean b =false;
        try {
            Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","123456");
            PreparedStatement pst =c1.prepareStatement("select * from us where zhanghao=? and psword =? and id=?");
            pst.setString(1,zhanghao);
            pst.setString(2,psword);
            pst.setInt(3,id);
            ResultSet rs =pst.executeQuery();

            while(rs.next()){
                b =true;
                return b;
                /*if(rs.getString(1)==zhanghao &&rs.getString(2)==psword ){
                    System.out.println(rs.getString(1)+rs.getString(2)+rs.getInt(3));
                    return true;
                }*/
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;


    }
    public statics void main(String[] args) {
   new preparedStatment();
        boolean b = mysql("23566862","zxc1314520",1);
        System.out.println(b);
    }

    public statics void del(){

    }
}
