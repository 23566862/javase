package 其他;

public class BoxProduction implements  Runnable {
    private Box box;

    public BoxProduction(Box box){
        this.box = box;
    }

    @Override
    public void run() {
        while(true){
            synchronized (this.box){
                this.box.put();
            }
        }
    }
}
