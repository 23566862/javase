public class joinCalss extends  Thread {
    public joinCalss(){}
    public joinCalss(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println(getName()+":"+i);
        }

    }
}
