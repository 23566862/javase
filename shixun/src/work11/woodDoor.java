package work11;

public class woodDoor extends AbstractDorr {
    //这是这木门，没有什么功能
    @Override
    public void openDoor() {
        System.out.println("木门开门");
    }
    @Override
    public void closeDoor() {
        System.out.println("木门锁门");
    }
    //木门自带功能
    public void keyDoor(){
        System.out.println("锁门方式为铁锁");
    }
}
