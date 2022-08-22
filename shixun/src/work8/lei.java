package work8;

public class lei {
    /* private String zhanghao;
     private String pword;
     private String e_mail;*/
    //无参构造
    public lei() {
    }

    //三个变量构造
    public lei(String zhaoghao, String b, String c) {
       /*this.zhanghao =zhaoghao;
       this.pword =b;
       this.e_mail =c;*/
        System.out.println(zhaoghao + "," + b + "," + c + "@gameschool.com");
    }

    //两个变量构造
    public lei(String zhaoghao, String b) {
       /* this.zhanghao =zhaoghao;
        this.pword =b;*/
        System.out.println(zhaoghao + "," + b + "," + zhaoghao + "@gameschool.com");
    }


}
