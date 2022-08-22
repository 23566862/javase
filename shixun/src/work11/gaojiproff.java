package work11;

public class gaojiproff extends AbstractDorr implements tenyou {
    //重写抽象类方法
    @Override
    public void openDoor() {
        System.out.println("开门为密码加指纹的方式");
    }

    @Override
    public void closeDoor() {
        System.out.println("关门需要二次确定");
    }

    //实现接口，重写方法
    @Override
    public void theftproof() {
        System.out.println("这是防盗门");
    }

    @Override
    public void waterproof() {
        System.out.println("防水");
    }

    @Override
    public void fireporoof() {
        System.out.println("防火");
    }

    @Override
    public void bulletproof() {
        System.out.println("防弹");
    }

    @Override
    public void rustporoof() {
        System.out.println("不锈钢门，质量好");
    }
}
