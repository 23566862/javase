package BookSystem.版本1;

import javax.swing.*;
import java.util.Scanner;

public class BookViewgui extends AbstractBookView {
    private bookController book = null;
    private Scanner sc = null;
    public BookViewgui() {
        book = new bookController();
        sc =new Scanner(System.in);
        while(true){monu();}
    }

    @Override
    //菜单选择
    public String viewMainApp() {
        String meun ="\nx9图书管理系统 >> 主菜单\n";
        meun +="1. 添加图书\t2.删除图书\t3.查询所有图书\t4. 编号查询图书\t5.入库\t6.出库\t7.退出\n";
        meun +="请输入你的选择:";
        String s = JOptionPane.showInputDialog(meun);
        if(s ==null){
            s="7";
        }
        return s;
    }
    //菜单
    public void monu(){
        String choie = viewMainApp();
        switch (choie) {
            case "1":
                //添加图书
                Book book = viewAddBook();
                this.book.addBook(book);
                break;
            case "2":
                //删除图书
                remove();
                break;
            case "3":
                //查询所有图书

                break;
            case "4":
                //编号查询图书
                idshow();
                break;
            case "5":
                //入库
                viewinstore();
                break;
            case "6":
                //出库
                viewoutstore();
                break;
            case "7":
                System.exit(0);
                break;
            default:
                System.out.println("请输入1-7的选择!");
        }
    }

    //添加图书
    @Override
    public Book viewAddBook() {
        Book newbook =new Book();
        String idcard =null;    //图书编号
        String isbn =null;      //出版号
        int count =-1;      //图书库存
        double price =-1;      //图书单价
        idcard =JOptionPane.showInputDialog("请输入图书编号:");
        if(book.fiindbyid(idcard) ==null){
            newbook.setBookid(idcard);
            isbn =JOptionPane.showInputDialog("请输入出版号:");
            newbook.setIsbn(isbn);
            while(true) {
                String count1 = JOptionPane.showInputDialog("输入图书库存：");
                if (!book.isdigit(count1)) {
                    count = Integer.valueOf(count1);
                    newbook.setCount(count);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null,"请输入整数!");
                    continue;
                }
            }

            while(true) {
                String price1 =JOptionPane.showInputDialog("输入图书单价：");
                if (book.isnum(price1)) {
                    price = Integer.valueOf(price1);
                    newbook.setPrice(price);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "请输入整数!");
                    continue;
                }
            }

        }else{
            JOptionPane.showMessageDialog(null,"图书编号已存在!");
            viewAddBook();
        }
        JOptionPane.showMessageDialog(null,"图书添加成功！");
        return newbook;
    }

    @Override
    public void remove() {

    }

    @Override
    public void showbook(Book... Bookarray) {
        int count =book.getbookcount(Bookarray);
       if(count ==0){
           JOptionPane.showMessageDialog(null,"请添加后重试！");
       }else{
           for (int i = 0; i <count ; i++) {

           }
       }
    }

    //查询图书
    @Override
    public void idshow() {

    }

    @Override
    public void viewinstore() {

    }

    @Override
    public void viewoutstore() {

    }
}
