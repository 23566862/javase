package 特殊操作流;

import java.io.*;

public class 对象序列化流 {
    public static void main(String[] args) {
        // wirth();
        read();

    }

    public static void wirth() {
        //把对象写入文件，字符序列显示
        //序列化
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Io\\对象序列化.txt"));
            Students s = new Students();
            oos.writeObject(s);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read() {
        //反序列化
        try {
            ObjectInputStream ops = new ObjectInputStream(new FileInputStream("Io\\对象序列化.txt"));
            Object boj = ops.readObject();  //超类object接收
            Students s = (Students) boj; //向下转型
            s.setAddress("123");
            s.setAge(45);
            s.setName("qqq");
            System.out.println(s.getAddress() + "," + s.getName() + "," + s.getAge());
        } catch (IOException | ClassNotFoundException c) {
            c.printStackTrace();
        }
    }

}
