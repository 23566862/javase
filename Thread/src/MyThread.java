public class MyThread extends Thread {
    public MyThread() {
    }
    public MyThread(String name){
        super(name);    //调用父类构造
    }

    //继承thread类重写run方法
    @Override
    public void run() {
        for (int i = 1; i <100 ; i++) {
            //查看线程名称
            System.out.println(getName()+":"+i);

        }

    }
}
