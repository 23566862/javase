public class deaemo extends Thread {
    public deaemo(){}
    public deaemo(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println(getName() + ":" + i);
        }

    }
}
