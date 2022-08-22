package YIChang;

public class censhi {
    public static void main(String[] args) {
        System.out.println("开始");
        mendom();
        System.out.println("结束");
        System.out.println("////");
    }
    public static void mendom(){
        try {
            int[] arr = {14, 15, 2, 3};
            System.out.println(arr[5]);
        }catch(ArrayIndexOutOfBoundsException a){
            System.out.println(a.getMessage());
            System.out.println(a.toString());
            a.printStackTrace();
        }
    }
}
/*Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 5
	at YIChang.censhi.mendom(censhi.java:10)
	at YIChang.censhi.main(censhi.java:5)
*/
