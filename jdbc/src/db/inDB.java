package jdbc.src.db;

import java.sql.*;

public class inDB {

    public inDB(){
        Connection c =null; //获取连接
        Statement st =null; //发送sql语句
        ResultSet rs =null;//放回处理结果
        //获取连接
        try {
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","123456");
            st=c.createStatement(); //创建statement对象
            rs =st.executeQuery("select * from stu   ");
            //String s ="insert into stu(id,name,sex,brithy)values('5','男刀','男','2019-1-1')";
          /*  int rest = st1.executeUpdate(s);
            System.out.println(rest);*/
            while(rs.next()){
                rs.getString(1);
                String id =rs.getString("id");
                String name =rs.getString("name");
                String sex =rs.getString("sex");
                String bri =rs.getString("brithy");
                System.out.println(id+name+sex+bri);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(st!=null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(c!=null){
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(c);
    }
    public static void main(String[] args) {
    new inDB();
    }
}
