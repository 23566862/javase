package Data.src.GongJuLei;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class  lei {
    //定义工具类，构造方法私有，成员方法静态
    private lei(){

    }

    public static String gongju(Date date,String geshi ){
        SimpleDateFormat sdf =new SimpleDateFormat(geshi);
        String s =sdf.format(date);
        return s;
    }

    public static Date jiexi(String s,String geshi) throws ParseException {
        SimpleDateFormat sdf =new SimpleDateFormat(geshi);
        Date d =sdf.parse(s);
        return d;
    }
}
