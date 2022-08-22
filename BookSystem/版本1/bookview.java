package BookSystem.版本1;

import java.io.IOException;
import java.util.Scanner;

//视图层,菜单层
public class bookview {
    private Scanner sc = null;
    private bookController book = null;

    //登录主菜单
    public bookview() throws IOException {
        sc = new Scanner(System.in);
        book = new bookController();
        System.out.println("---欢迎使用x9图书管理系统-----");
        while (true) {
            System.out.println("1.登入\t2.注册\t3.退出系统");
            //System.out.println("2. 注册");
            System.out.println("请输入你的选择：");
            String choie = sc.next();

            //登入
            if (choie.equals("1")) {
                viewlogin();
                break;
            }

            //注册
            if (choie.equals("2")) {
                viewlogon();
            }
            //3 退出系统
            if (choie.equals("3")) {
                System.out.println("程序已退出!");
                break;
            } else {
                System.out.println("请输入正确的选择!");
            }

        }
        /*Book book = viewAddBook();
        showbook(datas.bookStore);*/
        /*book = new bookController();
        sc = new Scanner(System.in);
       viewAddBook();*/
    }

    //登入成功后的图书管理系统界面
    public void viewMainApp() {
        System.out.println("\nx9图书管理系统 >> 主菜单");
        System.out.println("1. 添加图书\t2.删除图书\t3.查询所有图书\t4. 编号查询图书\t5.入库\t6.出库\t7.退出");
        System.out.println("请输入你的选择:");
        String choie = sc.next();
        switch (choie) {
            case "1":
                //添加图书
                Book book1 = viewAddBook();
                this.book.addBook(book1);
                showbook(book1);
                break;
            case "2":
                //删除图书
                remove();
                break;
            case "3":
                //查询所有图书
                showbook(datas.bookStore);
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

    //登入
    public void viewlogin() throws IOException {
        System.out.println("请输入你的账号：");
        String zhaohao = sc.next();
        System.out.println("请输入你的密码：");
        String password = sc.next();
        boolean b = book.login(zhaohao, password);
        //为true登录成功进入图书系统
        if (b) {
            while (true) {
                viewMainApp();
            }
        } else {
            System.out.println("你输入的账号或者密码有误!");
        }
    }

    //注册
    public void viewlogon() throws IOException {
        while (true) {
            System.out.println("请输入你要注册的账号：");
            String zhaohao = sc.next();
            System.out.println("请输入你的密码：");
            String password = sc.next();
            boolean b = book.zhucen(zhaohao, password);
            if (b) {
                System.out.println("注册成功");
                break;
            } else {
                System.out.println("账号长度要小于10，密码不能为纯数字");
                continue;
            }
        }
    }

    //添加图书
    public Book viewAddBook() {
        System.out.println("主菜单 >>添加图书");
        System.out.println("图书编号：");
        String idcard = sc.next();
        Book newbook = book.fiindbyid(idcard);
        //判断新增图书编号是否存在，为null不存在
        if (newbook == null) {
            newbook = new Book();
            newbook.setBookid(idcard);
            System.out.println("图书名称：");
            newbook.setBookname(sc.next());
            System.out.println("图书出版号:");
            newbook.setIsbn(sc.next());
            System.out.println("图书库存：");
            while (true) {
                String count = sc.next();
                if (!book.isdigit(count)) {
                    newbook.setCount(Integer.valueOf(count));
                    break;
                } else {
                    System.out.println("请输入整数：");
                    continue;
                }
            }
            System.out.println("图书单价:");
            while (true) {
                String price = sc.next();
                if (book.isnum(price)) {
                    double preice = Double.valueOf(price);
                    newbook.setPrice(preice);
                    break;
                } else {
                    System.out.println("请输入整数：");
                    continue;
                }
            }
            System.out.println("添加成功！");
        } else {
            System.out.println("图书编号已存在！");
            newbook = viewAddBook();
        }
        return newbook;
    }

    //遍历图书
    public void showbook(Book... Bookarray) {
        System.out.println("主菜单 >>查看所有图书");
        int count = book.getbookcount(Bookarray);
        if (count == 0) {
            System.out.println("请添加后在重试");
        } else {
            System.out.println("名称\t\t编号\t出版号\t库存\t\t单价");
            for (int i = 0; i < count; i++) {
                System.out.println(Bookarray[i].getBookname() + "\t" + Bookarray[i].getBookid() + "\t" + Bookarray[i].getIsbn() + "\t" + Bookarray[i].getCount() + "\t\t" + Bookarray[i].getPrice());
            }
        }

    }

    //删除图书
    public void remove() {
        System.out.println("主菜单 >>删除图书");
        int count1 = book.getbookcount();
        if (count1 == 0) {
            System.out.println("请添加后在重试");
        } else {
            System.out.println("删除的图书编号:");
            String idcard = sc.next();
            int idex = -1;
            int count = book.getbookcount();
            for (int i = 0; i < count; i++) {
                if (datas.bookStore[i].getBookid().equals(idcard)) {
                    idex = i;
                    if (book.removebook(datas.bookStore[idex])) {
                        System.out.println("删除成功！");
                    }
                    break;
                }
                System.out.println("你要删除编号不存在!");
                break;
            }
        }

    }

    //编号查询
    public void idshow() {
        System.out.println("主菜单 >>编号查询");
        int count1 = book.getbookcount();
        if (count1 == 0) {
            System.out.println("请添加后在重试");
        } else {
            System.out.println("图书编号：");
            String idcard = sc.next();
            Book fiindbyid = book.fiindbyid(idcard);
            if (fiindbyid == null) {
                System.out.println("没有你要查找的编号书籍");
            } else {
                showbook(fiindbyid);
            }
        }

    }

    //入库
    public void viewinstore() {
        int count1 = book.getbookcount();
        if (count1 == 0) {
            System.out.println("请添加后在重试");
        } else {
            System.out.println("你要归还的图书编号：");
            String idcard = sc.next();
        /*Book fiindbyid = book.fiindbyid(idcard);
        if(fiindbyid ==null){
            System.out.println("图书编号不存在");
            viewinstore();
        }*/
            while (true) {
                System.out.println("图书数量：");
                String count = sc.next();
                boolean isdigit = book.isdigit(count);
                if (!isdigit) {
                    Integer value = Integer.valueOf(count);
                    boolean instore = book.instore(idcard, value);
                    if (instore) {
                        System.out.println("归还成功");
                        break;
                    } else {
                        System.out.println("图书编号不存在");
                      viewinstore();
                    }
                } else {
                    System.out.println("图书数量必须为整数");
                    continue;
                }
            }
        }

    }

    //出库
    public void viewoutstore() {
        int count1 = book.getbookcount();
        if (count1 == 0) {
            System.out.println("请添加后在重试");
        } else {
            System.out.println("你要借阅的图书编号：");
            String idcard = sc.next();
        /*Book fiindbyid = book.fiindbyid(idcard);
        if(fiindbyid ==null){
            System.out.println("图书编号不存在");
            viewinstore();
        }*/
            while (true) {
                System.out.println("图书数量：");
                String count = sc.next();
                boolean isdigit = book.isdigit(count);
                if (!isdigit) {
                    Integer value = Integer.valueOf(count);
                    boolean instore = book.outstore(idcard, value);
                    if (instore) {
                        System.out.println("借阅成功");
                        break;
                    } else {
                        System.out.println("图书编号不存在或者库存不足");
                        viewoutstore();
                    }
                } else {
                    System.out.println("图书数量必须为整数");
                    continue;
                }
            }
        }
    }
}



