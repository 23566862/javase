package FanXing;

//定义泛型类
public class generic<E>implements GenericInterface<E> {
    private E e;
    public E getE(){
        return e;
    }

    public void setE(E e){
        this.e =e;
    }

    //定义泛型方法
    public <E> void show(E e){
        System.out.println(e);
    }

    @Override
    public void show1(E e) {
        System.out.println(e);
    }
}
