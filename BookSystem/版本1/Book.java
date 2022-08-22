package BookSystem.版本1;

//开发使用mvc框架
//1 moudle 模块层
//2 view   视图层（界面）
//3 controller 控制层（业务逻辑）


//1 模块层
public class Book {
    private String bookname;    //图书名称
    private String bookid;      //图书编号
    private String isbn;        //图书出版号
    private String type;        //图书的类型
    private String author;      //图书作者
    private String publisher;   //出版社
    private int count;      //图书库存
    private double price;   //图书单价

    public Book() {
    }

    @Override
    public boolean equals(Object o) {
       //如果o等于空或者不是Book的实例对象就返回false
        if(o ==null || !(o instanceof Book) ){
           return  false;
       }
        //o强转为Book
        Book b =(Book)o;
        return bookid.equals(b.getBookid());
    }



    public Book(String bookname, String bookid, String isbn, String type, String author, String publisher, int count, double price) {
        this.bookname = bookname;
        this.bookid = bookid;
        this.isbn = isbn;
        this.type = type;
        this.author = author;
        this.publisher = publisher;
        this.count = count;
        this.price = price;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookname='" + bookname + '\'' +
                ", bookid='" + bookid + '\'' +
                ", isbn='" + isbn + '\'' +
                ", type='" + type + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}
