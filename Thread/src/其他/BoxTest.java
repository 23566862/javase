package 其他;

public class BoxTest {
    public static void main(String[] args) {
        Box box = new Box();
        BoxProduction bp = new BoxProduction(box);
        BoxConsumption bc = new BoxConsumption(box);
        Thread t1 = new Thread(bp);
        Thread t2 = new Thread(bc);
        t1.start();
        t2.start();
    }
}
