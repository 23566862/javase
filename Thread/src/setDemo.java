public class setDemo {
    public static void main(String[] args) {
        deaemo mt5 =new deaemo("线程5");
        deaemo mt6 =new deaemo("线程6");
        Thread.currentThread().setName("主线程");
       /* mt2.setDaemon(true);    //设置为守护线程
        mt3.setDaemon(true); */   //设置为守护线程*/
        mt5.start();
        try {
            mt5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mt6.start();
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }

    }
}
