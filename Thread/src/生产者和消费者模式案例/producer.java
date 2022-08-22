package 生产者和消费者模式案例;

public class producer implements  Runnable {
    //生产者
    private Box b;
    public producer(Box b){
        this.b =b;
    }
    @Override
    public void run() {
        for (int i = 1; i <=5 ; i++) {
            b.put(i);
        }
    }
}
