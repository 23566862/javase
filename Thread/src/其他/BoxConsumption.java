package 其他;

public class BoxConsumption implements  Runnable {
    private Box box;

    public BoxConsumption(Box box){
        this.box = box;
    }

    @Override
    public void run() {
        while(true){
            synchronized (this.box){
                this.box.get();
            }
        }
    }
}
