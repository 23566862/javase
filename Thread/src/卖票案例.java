public class 卖票案例 {
    public static void main(String[] args)  {
        Sellintickets sc =new Sellintickets();
        //三个窗口卖票 创建三个线程
        Thread t =new Thread(sc,"窗口1");
        Thread t1 =new Thread(sc,"窗口2");
        Thread t2 =new Thread(sc,"窗口3");
        t.start();
        t1.start();
        t2.start();


    }
}
