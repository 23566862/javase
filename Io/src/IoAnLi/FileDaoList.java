package Io.src.IoAnLi;

import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;

public class FileDaoList {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("shixun\\Student.dat");
            BufferedReader br = new BufferedReader(fr);
            ArrayList<IoAnLi.lei> al = new ArrayList<>();
            String s;
            while ((s = br.readLine()) != null) {
                String[] split = s.split(",");  //把集合里的一行文件，以，分割存储
                IoAnLi.lei l = new IoAnLi.lei();
                l.setSno(split[0]);
                l.setName(split[1]);
                l.setMath(Integer.parseInt(split[2]));  //oarseint（）字符串转int
                l.setComputer(Integer.parseInt(split[3]));
                l.setAndroid(Integer.parseInt(split[4]));
                al.add(l);
                br.close(); //关闭流
            }
           /* for (lei l : al) {
                System.out.println(l.getSno() + "," + l.getName() + "," + l.getMath() + "," + l.getComputer() + "," + l.getAndroid());
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
