package javaPractice.src.wordDay13;

public class text {

    public static void  main(String[] args) {
        txe(99,Integer::toHexString);
    }
    public static void txe(int num, wordDay13.inface a){
        String s =a.CurrentTimePrinter(num);
        System.out.println(s);
    }
}
