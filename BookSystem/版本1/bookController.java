package BookSystem.版本1;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

//控制层（逻辑）,控制层尽量不要写输出语句，在视图层写
public class bookController {
    //判断当前图库里有多少个图书对象
    public int getbookcount() {
        int count = 0;
        for (Book b : datas.bookStore) {
            if (b == null) {
                break;
            }
            count++;
        }

        return count;
    }

    //获取你想要输出的book对象
    public int getbookcount(Book...books) {
        int count = 0;
        for (Book b : books) {
            if (b == null) {
                break;
            }
            count++;
        }

        return count;
    }

    //图书添加方法
    public boolean addBook(Book book) {
        //先进行判断图书对象是否为满
        int count = getbookcount(); //当前图书对象个数
        if (count == datas.bookStore.length) {
            return false;
        }
        //仓库不满就添加到第一个非空的图书对象里
        datas.bookStore[count] = book;
        return true;
    }

    //删除方法
    public boolean removebook(Book book) {
        int count = getbookcount();  //获取图书个数
        int idex = -1;
        //遍历进行判断是否相等,相等记录元素下标，等待删除
        for (int i = 0; i < count; i++) {
            /*if(book.getBookid().equals(datas.bookStore[i].getBookid())){}*/
            //Book里重写equals方法，简写
            if (book.equals(datas.bookStore[i])) {
                idex = i;
            }
        }
        //没有找到返回false
        if (idex == -1) {
            return false;
        }
        //有了元素下标，开始删除，从要删除的元素开始遍历，后面赋值给前面,再给最后一个元素标记为空
        for (int i = idex; i < count; i++) {
            datas.bookStore[i] = datas.bookStore[i + 1];
        }
        datas.bookStore[count - 1] = null;
        return true;
    }

    //按编号查找图书
    public Book fiindbyid(String id) {
        /*for (Book b:datas.bookStore){
            if(id.equals(b.getBookid())){
                return b;
            }
        }*/
        for (int i = 0; i < getbookcount(); i++) {
            if (id.equals(datas.bookStore[i].getBookid())) {
                return datas.bookStore[i];
            }
        }
        return null;
    }


    //入库，指在库里有的图书增加图书数量，没有就放回false
    public boolean instore(String id, int count) {
            Book book = fiindbyid(id);
            if (book == null) {
                return false;
            }
            //如果存在，就现在数量加上一起数量
            book.setCount(book.getCount() + count);
            return true;
    }

    //出库，减少库存
    public boolean outstore(String id,int count){
        Book book = fiindbyid(id);
        if(book ==null){
            return false;
        }
        //判断库存是否充足
        if(book.getCount() < count){
            return false;
        }
        book.setCount(book.getCount()-count);
        return true;
    }

    //注册图书管理系统
    public boolean zhucen(String meail,String pasword) throws IOException {
        if(meail.length()<10 && isdigit(pasword)){
            Properties p =new Properties();
            p.put(meail,pasword);
            FileWriter fw =new FileWriter("BookSystem\\user.txt",true);
            p.store(fw,null);
            fw.flush();
            fw.close();
            return true;
        }
        return false;
    }

    public boolean login(String meail,String pasword) throws IOException {
        Properties p =new Properties();
        FileReader fr =new FileReader("BookSystem\\user.txt");
        p.load(fr);
         p.getProperty(meail);
        if(p.getProperty(meail)==null){
            fr.close();
            return false;
        }if(p.getProperty(meail).equals(pasword)){
            fr.close();
            return true;
        }
        fr.close();
        return false;

    }

    //判断是否为纯数字
    public boolean isdigit(String pasword){
       /* if(pasword.matches("^[0-9]+\\.{0,1}[0-9]{0,2}$")){
            //pasword.matches("^[0-9]+\\.{0,1}[0-9]{0,2}$");//判断是否为纯数字包括.
            return false;
        }*/
        if(pasword.matches("[0-9]+")){
            return false;
        }/*else if(pasword.matches("^[0-9]+\\.{0,1}[0-9]{0,2}$")){
            return false;
        }*/
        return true;
    }

    //判断是否为纯数字包括小数
    public boolean isnum(String num){
        if(num.matches("^[0-9]+\\.{0,1}[0-9]{0,2}$")){
            return true;
        }
        return false;
    }

    /*//小数字符串转double
    public double doubleof(String num){
        int i = num.indexOf(".");
        if(i<0){
            int value = Integer.valueOf(num);
            return value;
        }else{

        }
        return i;
    }*/





}
