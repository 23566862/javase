package YIChang;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class qubei {
    public static void main(String[] args) {
        try {
            menthod();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        menthod2();
        System.out.println("结束");
    }
//编译时异常
    public static void menthod() throws ParseException {
            String s = "2018-5-6";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sdf.parse(s);
            System.out.println(d);

    }

    //运行时异常
    public static void menthod2(){
        try {
            int[] arr = {45, 55, 44};
            System.out.println(arr[5]);
        }catch(ArrayIndexOutOfBoundsException a){
            a.printStackTrace();
        }
    }
}
