public class bookClass {
    private String bookid;
    private String bookname;
    private int price;
    private int booknumber;
    private String date;
    private String press;
    public bookClass(){}

    public bookClass(String bookid, String bookname, int price, int booknumber, String date, String press) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.price = price;
        this.booknumber = booknumber;
        this.date = date;
        this.press = press;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBooknumber() {
        return booknumber;
    }

    public void setBooknumber(int booknumber) {
        this.booknumber = booknumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }
}
