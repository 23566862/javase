package wordPractice;

public class day11Runtable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"：线程已经启动");
    }
}
