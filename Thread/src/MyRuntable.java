public class MyRuntable implements Runnable {
    @Override
    public synchronized void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);

        }
    }
}
