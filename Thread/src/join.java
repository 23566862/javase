public class join {
    public static void main(String[] args)  {
        //join()
        //等待这个线程死亡。
        joinCalss mt1 =new joinCalss("线程1");
        joinCalss mt2 =new joinCalss("线程2");
        joinCalss mt3 =new joinCalss("线程3");
        mt1.start();
        try {
            mt1.join();     //等待这个线程结束在执行其他线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mt2.start();
        mt3.start();
    }
}
