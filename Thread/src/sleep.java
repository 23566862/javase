public class sleep {
    public static void main(String[] args)  {
        //sleep(long millis)
        //使当前正在执行的线程以指定的毫秒数暂停（暂时停止执行），
        // 具体取决于系统定时器和调度程序的精度和准确性
        sleeepCalss mt1 =new sleeepCalss("线程1");
        sleeepCalss mt2 =new sleeepCalss("线程2");
        sleeepCalss mt3 =new sleeepCalss("线程3");
        mt1.start();
        mt2.start();
        mt3.start();

    }
}
