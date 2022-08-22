package wordPractice;

public class day11Work6 implements Runnable {
    private int count =0;
    @Override
    public synchronized void run() {
        try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
        }
        ++count;
        System.out.println(Thread.currentThread().getName()+ "他是第"+count+"个通过隧道的");

    }
}
