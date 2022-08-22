package Io.src.IoAnLi;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class DianMingQi {
    public static void main(String[] args) throws IOException {
        FileReader f = new FileReader("Io\\OutPutStreamWriter.txt");
        BufferedReader br = new BufferedReader(f);
        ArrayList<String> al = new ArrayList<>();
        String s;
        while ((s = br.readLine()) != null) {
            al.add(s);
        }
        /*int size =al.size();
        int count =(int)(Math.random()*10-4);   取值范围*/
        Random r = new Random();
        int idex = r.nextInt(al.size());     //第二种方式设置取值范围
        System.out.println("幸运者是：" + al.get(idex));
    }
}
