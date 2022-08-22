public class implementRuntable  {
    public static void main(String[] args) {
       //直接实现runtable接口创建多线程
        MyRuntable mr =new MyRuntable();    //创建对象
        //通过thread类的构造方法实现多线程
        Thread t =new Thread(mr,"线程1");
        Thread t1 =new Thread(mr,"线程2");
        t.start();
        t1.start();
    }


}
