public class implmentsThread extends Thread  {
    public static void main(String[] args) {
      /*  MyThread mt =new MyThread(); //创建对象
            MyThread mt1 =new MyThread();*/
        //方法1调用父类方法设置线程名称
//        mt.setName("线程1");
//        mt1.setName("线程2");
        //方法2创建对象时设置名称，需要创建构造方法，有参构造调用父类构造
        MyThread mt =new MyThread("线程1");
        MyThread mt1 =new MyThread("线程2");
        mt.start(); //启动线程
        mt1.start();
        //currentThread()返回对当前正在执行的线程对象的引用
        System.out.println(Thread.currentThread().getName());   //查看main方法线程

        //设置线程的优先级和查看
        System.out.println(mt.getPriority());
        System.out.println(mt1.getPriority());
        //设置线程的优先级，范围为1-10，10为高   ,为高只是获取cpu内存多，不代表优先
        mt.setPriority(10);
        mt1.setPriority(5);




    }


}
