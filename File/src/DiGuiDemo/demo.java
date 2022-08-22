package src.DiGuiDemo;

import java.io.File;

public class demo {
    public static void main(String[] args) {
        //实现内容 用递归查看file路径下的所有文件
        //步骤
        // 1  创建file路径对象
        // 2 创建查找file下文件的方法，参数为file
        // 3 用file.listFile方法接收File类型数组
        //4 遍历file数组判断是否为目录
        // 1 是  递归调用
        // 2 不是 ，输出绝对路径下文件
        //File f1 =new File("File\\Java");
       // System.out.println(f1.isDirectory());


        File f =new File("D:\\gta5");
        Path(f);

    }

    public static int metho(int n){     //递归求阶乘
        if(n ==1){
            return 1;
        }else {
            return n * metho(n - 1);
        }
    }

    public  static void Path(File file){
        File [] mulu =file.listFiles();
        if(file != null) {
            for (File file1 : mulu) {
                if (file1.isDirectory()) {
                    Path(file1);
                } else {
                    System.out.println(file1.getAbsolutePath());
                }
            }
        }
    }


}
