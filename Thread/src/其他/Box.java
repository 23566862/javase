package 其他;

public class Box {
    private int milk = 1;

    public void put(){
        if(this.milk > 0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("生产牛奶");
        notifyAll();
    }

    public void get(){
        if(this.milk > 0){
            System.out.println("消费牛奶");
            notifyAll();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
