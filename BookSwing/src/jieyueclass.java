public class jieyueclass {
    private String bookid;
    private String bookname;
    private int id;
    private String name;
    private String date;
    private int zhuantai;
    public jieyueclass() {
    }

    public jieyueclass(String bookid, String bookname, int id, String name, String date, int zhuantai) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.id = id;
        this.name = name;
        this.date = date;
        this.zhuantai = zhuantai;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getZhuantai() {
        return zhuantai;
    }

    public void setZhuantai(int zhuantai) {
        this.zhuantai = zhuantai;
    }
}
