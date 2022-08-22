package src.File;

import java.io.File;
import java.io.IOException;

public class demo {
    public static void main(String[] args) throws IOException {
       //绝对路径：就是完整的路径
        //相同路径：在当前窗口下的路径

        //添加
        File f =new File("File\\File.txt");
        System.out.println(f.createNewFile());
        //删除对象文件
        System.out.println(f.delete());

        //在本路径下创建Java目录里面创建Java.txt
        File f1 =new File("File\\Java");
        System.out.println(f1.mkdirs());
        File f2 =new File(f1,"java.txt");
        System.out.println(f2.createNewFile());

        //当你要删除Java目录，需要先删除里面内容
        System.out.println(f2.delete());
        System.out.println(f1.delete());

    }
}
