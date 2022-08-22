package Generic.src.FanXing;

import org.omg.CORBA.StringHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class text {
    public static void main(String[] args) {
        FanXing.generic g =new FanXing.generic();
        g.setE("123453");
        g.setE(123);
        System.out.println(g.getE());
        g.show(123);
        g.show1("12345");
        ArrayList S =new ArrayList();
        sum(1312,1,3,6,7,9,5);

    }

    public static int sum(int...a){
        int sun =0;
        for(int i:a){
            sun +=i;
        }
        return sun;
    }
}
