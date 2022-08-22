package Lei.src.Lei;

//类的定义
public class LeiDingYi {
    //类的定义
    private int age;
    public String name;
    public String schoolname;

    //构造方法的定义
    public LeiDingYi() {
        System.out.println("构造方法");
    }

    //private 修饰的成员变量用set 和get 方法获取值
    public void setAge(int a) {
        this.age = a;
        if (a <= 0 || a >= 120) {
            System.out.println("你输入的值有误");
        } else
            System.out.println(a);
    }

    //返回age的值
    public int getAge() {

        return age;
    }

    //行为,方法
    public void homework() {

        System.out.println("做语文作业");
    }

    public void readboook() {

        System.out.println("学数学");
    }

    /*public static void main(String[] args) {
        for (int i = 0; i <4 ; i++) {
            for (int j = 1; j <10 ; j=j+2) {
                System.out.println("*");
            }
            System.out.println('\n');
        }
    }*/

}
