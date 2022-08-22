package Io.src.ArrayListAndIo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileArraylist {
    public static void main(String[] args) throws IOException {
        //实现内容，从文件内容添加到集合
        //步骤
        //1 创建读取对象
        //2 创建集合对象
        //3 遍历文件内容，添加对象
        FileReader fr = new FileReader("Io\\coby.java");
        BufferedReader br = new BufferedReader(fr);
        String s;
        ArrayList<String> al = new ArrayList<>();
        while ((s = br.readLine()) != null) {    //br.readeline()读取一行数据
            al.add(s);
        }
        //遍历
        for (String s1 : al) {
            System.out.println(s1);
        }
    }
}
