package 生产者和消费者模式案例;

public class Box {
    private int milik = 1;   //牛奶个数
    private boolean bo = false;   //牛奶状态

    public synchronized void get() { //消费者
        if (!bo) {    //如果没有牛奶，就等待生产
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("用户收到了第" + milik + "瓶奶");
        //改变牛奶状态
        bo = false;
        //唤醒
        notify();
    }

    public synchronized void put(int milik) {
        //生产者
        if (bo) { //有牛奶就等待消费
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.milik = milik;
        System.out.println("送奶工把" + milik + "瓶奶送到了奶箱");
        //改变牛奶状态
        bo = true;
        //唤醒其他线程
        notify();
    }
}
