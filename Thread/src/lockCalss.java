import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lockCalss implements Runnable {
    private int count = 100;
    Lock lc = new ReentrantLock();

    @Override
    public void run() {
        try{
            lc.lock();
            while (count > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在使用第" + count + "次");
                count--;
            }
        }finally{
            lc.unlock();
        }



    }
}

