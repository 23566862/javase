package 特殊操作流;

import java.io.*;

public class 打印流复制java文件 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Io\\coby.java"));
        PrintWriter pw = new PrintWriter(new FileWriter("Io\\打印流.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            pw.println(line);
        }
        pw.close();
        br.close();
    }
}
