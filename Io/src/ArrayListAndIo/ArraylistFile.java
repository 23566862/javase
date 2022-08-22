package Io.src.ArrayListAndIo;

import java.io.*;
import java.util.ArrayList;

public class ArraylistFile {
    public static void main(String[] args) throws IOException {
        //实现内容，把集合的元素复制到文件
        //步骤
        //1 创建集合对象
        //2 添加元素
        //3 创建字符缓存流对象
        //4 遍历集合然后写入文件
        //5 释放资源
        ArrayList<String> al = new ArrayList<>();
        al.add("中文");
        al.add("123");
        al.add("sdad");
        FileWriter fw = new FileWriter("Io\\ArraylistFile.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for (String s : al) {
            bw.write(s);
            bw.newLine();   //换行
            bw.flush();
        }
        bw.close();
        FileReader fr = new FileReader("Io\\ArraylistFile.txt");
        BufferedReader br = new BufferedReader(fr);
        char[] by = new char[1024];
        int count;
        while ((count = br.read(by)) != -1) {
            System.out.println(by);
        }


    }
}
