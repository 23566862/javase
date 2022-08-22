package work11;

public class dorrDemo {
    public static void main(String[] args) {
        //创建高级门对象，实现方法
        gaojiproff gj = new gaojiproff();
        gj.bulletproof();
        gj.closeDoor();
        gj.fireporoof();
        gj.openDoor();
        gj.rustporoof();
        gj.theftproof();
        gj.waterproof();
        System.out.println();
        //创建木门对象，
        woodDoor wd = new woodDoor();
        wd.closeDoor();
        wd.openDoor();
        wd.keyDoor();


    }
}
