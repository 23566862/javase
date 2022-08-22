package Io.src.BufferedInputStream;

import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class mp4Coby {
    public static void main(String[] args) throws IOException {
        //字节流复制视频
        // 1 创建读取字节流对象和写入字节流对象
        // 2 写入

        //写入视频开始时间
        long starTime = System.currentTimeMillis();

        //写入方法，
        //1 基本字节流单个字节写入
        // mertho();
        //2 基本字节流数组写入
        //mertho1();
        //3 字节缓存流单个写入
        //mertho2();
        //4 字节缓存流数组写入
        mertho3();

        //结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("总共用时：" + (endTime - starTime) / 1000 + "秒");

    }

    //1
    public static void mertho() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\heima\\csgo.mp4");
        FileOutputStream fos = new FileOutputStream("Io\\csgo.mp4");
        int by;
        while ((by = fis.read()) != -1) {
            fos.write(by);
        }
        fis.close();
        fos.close();
    }

    //2
    public static void mertho1() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\heima\\csgo.mp4");
        FileOutputStream fos = new FileOutputStream("Io\\csgo.mp4");
        byte[] by = new byte[1024];
        int count;
        while ((count = fis.read(by)) != -1) {
            fos.write(by, 0, count);
        }
        fis.close();
        fos.close();
    }

    //3
    public static void mertho2() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\heima\\csgo.mp4"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Io\\csgo.mp4"));
        int by;
        while ((by = bis.read()) != -1) {
            bos.write(by);
        }
        bis.close();
        bos.close();
    }

    //4
    public static void mertho3() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\heima\\csgo.mp4"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Io\\csgo.mp4"));
        byte[] by = new byte[1024];
        int count;
        while ((count = bis.read()) != -1) {
            bos.write(by, 0, count);
        }
        bis.close();
        bos.close();
    }
}
