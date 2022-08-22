package 生产者和消费者模式案例;

public class consumer implements Runnable { //消费者
    private Box b;
    public consumer(Box b){
        this.b =b;
    }
    @Override
    public void run() {
        while(true){b.get();}
    }
}
