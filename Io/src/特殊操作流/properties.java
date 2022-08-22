package 特殊操作流;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class properties {
    public static void main(String[] args) throws IOException {
        Properties p = new Properties();     //底层键和值类型为object类型
        p.put("2015", "44");
        p.put("2016", "d");
        p.put("2017", "dfs");
        //Properties特有方法
        //p.setProperty("sdaad","sdada");     //设置集合的键和值为String类型，并且添加
        String value = p.getProperty("2015");  //更具键获取值
        Set<String> set = p.stringPropertyNames();//获取键集合
        //System.out.println(value);
        Set<Object> ob = p.keySet();
        for (String s1 : set) {
            Object o1 = p.getProperty(s1);
            System.out.println(o1 + "," + o1);
        }
        //with();
        read1();
        Properties p1 = new Properties();
        FileWriter fw = new FileWriter("Io\\game.txt");
        p1.setProperty("count", "0");
        p1.store(fw, null);
    }

    public static void with() {
        try {
            Properties p = new Properties();     //底层键和值类型为object类型
            p.put("2015", "123");
            p.put("2016", "46");
            p.put("2017", "444");
            FileWriter fl = new FileWriter("Io\\properties.txt");
            p.store(fl, null);
            fl.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read1() {
        try {
            FileReader fd = new FileReader("Io\\properties.txt");
            Properties p = new Properties();
            p.load(fd);
            System.out.println(p);
            fd.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
