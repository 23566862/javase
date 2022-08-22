import com.sun.javaws.Launcher;

public class lock {
    public static void main(String[] args) {
        lockCalss l=new lockCalss();
        Thread t = new Thread(l,"线程1");
        Thread t1 = new Thread(l,"线程2");
        Thread t2 = new Thread(l,"线程3");
        t.start();
        t1.start();
        t2.start();
    }
}
