package wordPractice;

public class day11calss extends  Thread  {
    public day11calss(){}
    public day11calss(String s){
        super(s);
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":"+"线程已启动");
    }
}
