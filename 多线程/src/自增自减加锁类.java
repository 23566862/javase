package 多线程.src;

import java.util.concurrent.atomic.AtomicInteger;

public class 自增自减加锁类 {
    public static void main(String[] args) {
        /*自带锁可以自加自减*/
        AtomicInteger integer =new AtomicInteger();
        integer.incrementAndGet();//拿到当前的值
    }
}
