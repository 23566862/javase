package Text;

import java.io.IOException;

public class 数据库备份 {
    public static void main(String[] args) {
// 数据库导出
        String user = "root"; // 数据库帐号
        String password = "123456"; // 登陆密码
        String database = "user"; // 需要备份的数据库名
        String filepath = "d:\\user.sql"; // 备份的路径地址
        String stmt1 = "mysqldump " + database + " -u " + user + " -p" + password + " >" + filepath;
        String[] cmd = { "cmd", "/c", stmt1 };
        /*
         * --result-file=+" --result-file=" String mysql="mysqldump test -u root
         * -proot --result-file=d:\\test.sql";
         */
        try {
             Runtime.getRuntime().exec(stmt1);
            Runtime.getRuntime().exec(cmd);
            System.out.println("数据已导出到文件" + filepath + "中");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

