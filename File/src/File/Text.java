package src.File;
import java.io.File;
import java.io.IOException;

public class Text {
    public static void main(String[] args) throws IOException {

        //File创建对象
        File f =new File("D:\\heima\\File.TXT");
        System.out.println(f);

        //在D:\heima目录下创建file.txt文件
        //创建成功返回true，如果存在则返回false
        File f1 =new File("D:\\heima\\File.txt");
        //File新建功能
        System.out.println(f1.createNewFile());

        //File判断和获取方法
        System.out.println(f1.isFile());        //判断创建的是否为文件
        System.out.println(f1.isDirectory());   //判断是否为目录
        System.out.println(f1.exists());        //判断路径下的File是否存在
        System.out.println(f1.getAbsolutePath());   //返回绝对路径下绝对字符串名
        System.out.println(f1.getPath());       //返回路径下的路径名转为字符串
        System.out.println(f1.getName());       //返回最后一级里的文件和目录
        System.out.println();

        //在D:\heima目录下创建Java目录
        //创建成功返回true，如果存在则返回false
        File f2 =new File("D:\\heima\\Java");
        System.out.println(f2.mkdir());
        System.out.println(f2.getName());
        System.out.println();


        //在D:\heima目录下创建JavaWeb目录在创建HTML目录   创建多级目录
        File f3 =new File("D:\\heima\\JavaWeb\\HTML");
        System.out.println(f3.mkdirs());
        System.out.println(f3.getName());
        System.out.println();

        //在f3对象的基础在添加FirstDeo.txt文件
        File f4 =new File(f3,"FirstDeo.txt");
        System.out.println(f4.createNewFile());
        System.out.println("-------");

        File f5 =new File("D:\\heima");
        //用字符串数组接收路径下的文件和目录
        String [] arr =f5.list();
        for (String s:arr){
            System.out.println(s);
        }
        System.out.println("--------");

        //用File数组来接收此路径下的文件和目录
        File [] file =f5.listFiles();
        for (File file1:file){
            //System.out.println(file1);
            //用Files数组接收则可以进行判断输出目录或者文件
            if(file1.isFile()){
                System.out.println(file1);
            }
        }




    }
}
