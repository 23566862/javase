public class Sellintickets implements Runnable {
    private int tickes = 1;

    @Override
    public void run() {
        /*synchronized (ob) {     //使用synchronized锁住相同语句共享数据代码
            *//*while (tickes < 100) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "：卖出的第" + tickes + "张票");
                        ++tickes;
                    }
                }*//*

        }*/
        maipiao();
    }

    //使用同步方法解决同步问题
    public synchronized void maipiao(){
            while (tickes < 100) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "：卖出的第" + tickes + "张票");
                ++tickes;
            }
        }
    }



