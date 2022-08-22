package 案例;

public interface Lambda {
    /*int eat(String a,String b);
    //jdk8之后接口里增加的方法类型
    //1 默认方法
    default void show3(){
    }*/
    //int eat(String a);
    String show(String b);
    //jdk8之后接口里增加的方法类型
    //1 默认方法
    default void show3(){
    }
    //2 静态方法
    static void show4(){}

    //jdk9加入私有方法

}
