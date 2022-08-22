package Io.src.danji;

import java.io.*;

public class danjiFile {
    public static void main(String[] args) throws IOException {
        //创建要复制的文件夹路径
        File f = new File("D:\\heima");
        String path = f.getName();   //得到文件夹的名字，为下面复制创建文件夹名字

        //创建目的在文件，复制文件路径
        File cobyf = new File("Io\\", path);      //
        if (!cobyf.exists()) {    //判断文件夹是否存在
            cobyf.mkdir();  //不存在就创建
        }

        //得到file f 对象下的所有对象
        File[] files = f.listFiles();
        for (File f1 : files) {
            String filename = f1.getName();
            File fl = new File(f, filename);  //本地文件file对象
            File cobyf2 = new File(cobyf, filename);  //创建文件file对象
            cobyfile(fl, cobyf2);    //f1本地要读取file，cobyf2要写入file
        }
    }

    public static void cobyfile(File f, File f1) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));   //读取
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f1));
        //这里采用字节流写入读取
        byte[] by = new byte[1024];
        int count;
        while ((count = bis.read(by)) != -1) {
            bos.write(by, 0, count);
        }
        bis.close();
        bos.close();
    }
}
