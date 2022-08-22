package Io.src.IoException;

import java.io.FileOutputStream;
import java.io.IOException;

public class Finally {
    public static void main(String[] args) {

        //用try catch解决异常，并且用Finally释放资源
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("Io\\IoException.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}

