package BookSystem.版本1;

import java.util.Scanner;

public abstract class AbstractBookView {
    private Scanner sc = null;
    private bookController book = null;
    public AbstractBookView(){
        sc = new Scanner(System.in);
        book = new bookController();
    }
    //登入成功后的图书管理系统界面
    public abstract String viewMainApp();
    //添加图书
    public abstract Book viewAddBook();
    //遍历图书
    public abstract void showbook(Book... Bookarray);
    //删除图书
    public abstract void remove();
    //编号查询
    public abstract void idshow();
    //入库
    public abstract void viewinstore();
    //出库
    public abstract void viewoutstore();
}
