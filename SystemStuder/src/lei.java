public class lei {
    private  String Sno; //学号
    private String name;    //姓名
    private int math;   //数学
    private int computer;   //计算机
    private int android;    //安卓
    private int sum;        //总分

    public lei() {
    }

    public lei(String sno,String name,int math, int computer, int android) {
       this.Sno =sno;
        this.name = name;
        this.math = math;
        this.computer = computer;
        this.android = android;

    }

    //总和方法
    public int GetSumScore() {
        return this.android + this.computer + this.math;
    }

    public void setSno(String sno){
        this.Sno =sno;
    }
    public String getSno() {
        return Sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getComputer() {
        return computer;
    }

    public void setComputer(int computer) {
        this.computer = computer;
    }

    public int getAndroid() {
        return android;
    }

    public void setAndroid(int android) {
        this.android = android;
    }
}
