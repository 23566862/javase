package javaPractice.src.wordPractice;

public class day11 {
    public static void main(String[] args) {
        //work1();
        //work2();
        //work3();
        //work4();
        //work5();
        work6();
    }

    public static void work1() { //方法1继承thread启动线程
        wordPractice.day11calss d = new wordPractice.day11calss("线程1");
        //d.setName("线程1");
        d.start();

    }
  
    public static void work2() {
        wordPractice.day11Runtable d = new wordPractice.day11Runtable();
        Thread t = new Thread(d, "线程1");
        t.start();
    }

    public static void work3() {
        Thread t = new Thread(new wordPractice.day11Work2());
        t.start();
        while (true) {
            System.out.println("主线程正在执行");
        }
    }
    //匿名内部类创建线程
    public static void work4(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                System.out.println("正在播放音乐....");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                System.out.println("显示画面.....");
                }
            }
        }).start();
    }
    public static void work5(){
        for (int i = 1; i <=20 ; i++) {
            System.out.println(Thread.currentThread().getName()+"正在执行第"+i+"次");
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=20 ; i++) {
                    System.out.println(Thread.currentThread().getName()+"正在执行第"+i+"次");
                }
            }
        }).start();
    }

    public static void work6(){
        String arr[] ={"小明","林青霞","郭芙蓉","xaioe","许仙","胡歌","吴彦祖","成龙","faker","uzi"};
       wordPractice.day11Work6 d =new wordPractice.day11Work6();
        for (int i = 0; i <10 ; i++) {
            Thread t =new Thread( d,arr[i]);
            t.start();
        }
    }
}
