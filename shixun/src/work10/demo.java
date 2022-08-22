package work10;

public class demo {
    public static void main(String[] args) {
        //创建car类
        Vehicle v = new Car();
        String s = v.NoOfWheels();
        System.out.println(s);

        //创建motorbike类
        Vehicle v1 = new Motorbike();
        String s1 = v1.NoOfWheels();
        System.out.println(s1);
    }
}
