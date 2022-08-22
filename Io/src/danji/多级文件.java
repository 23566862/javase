package Io.src.danji;

import java.io.*;

public class 多级文件 {
    public static void main(String[] args) {
        //实现步骤
        //多级文件需要创建方法判断是否为文件或文件夹
        //是文件，
        //1 接收文件夹名称 ，递归调用继续判断

        //不是，直接复制
        File srcfile = new File("D:\\heima");  //本地文件
        File cobyfile = new File("Io\\");
        isfile(srcfile, cobyfile);

    }

    public static void isfile(File srcFile, File cobyfile) {
        if (srcFile.isDirectory()) {  //是否为文件夹
            //给目的地文件下创建更源文件一样的文件名
            String filename = srcFile.getName();
            File newfile = new File(cobyfile, filename);   //目的地文件名
            //目的地文件不存在就创建目录
            if (!newfile.exists()) {
                newfile.mkdir();
            }
            //遍历源文件，递归调用
            File[] arr = srcFile.listFiles();
            for (File s : arr) {
                isfile(s, newfile);
            }
        } else {
            File newfile = new File(cobyfile, srcFile.getName());
            cobyfile(srcFile, newfile);
        }

    }

    public static void cobyfile(File srcFile, File cobyfile) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile)); //缓冲输入字节流
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(cobyfile));) {
            byte[] by = new byte[1024];
            int len;
            while ((len = bis.read(by)) != -1) {
                bos.write(by, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

