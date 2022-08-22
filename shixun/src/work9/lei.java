package work9;

public class lei {
    /*构造方法与重载 创建一个类 为该类定义三个构造方法 分别执行下列操作 1、传递两个整数值并找出其中较大的一个值 2、传递三个double值并求出其乘积 3、传递两个字符串值并检查其是否相同 4、在main方法中测试构造函数的调用。
            10、抽象类 创建一个Vehicle类并将它声明为抽象类。在Vehicle类中声明一个NoOfWheels方法 使它返回一个字符串值。
            创建两个类Car和Motorbike从Vehicle类继承 并在这两个类中实现NoOfWheels方法。
            在Car类中 应当显示“四轮车”信息 而在Motorbike类中 应当显示“双轮车”信息。
            创建另一个带main方法的类 在该类中创建Car和Motorbike的实例 并在控制台中显示消息*/

    //1
    public lei(int a, int b) {
        int c = Math.max(a, b);
        System.out.println("最大值为：" + c);
    }

    //2
    public lei(double a, double b, double c) {
        double d = a * b * c;
        System.out.println("总和为：" + d);
    }

    //3
    public lei(String a, String b) {
        boolean br = a.equals(b);
        if (br) {
            System.out.println("字符串相同");
        } else {
            System.out.println("不相同");
        }
    }
}
