package 生产者和消费者模式案例;

public class text {
    public static void main(String[] args) {
        Box b = new Box();
        //生产者
        producer pc = new producer(b);

        //消费者
        consumer co = new consumer(b);

        //创建线程
        Thread t = new Thread(pc);
        Thread t1 = new Thread(co);

        //启动线程
        t.start();

        t1.start();
    }
}
