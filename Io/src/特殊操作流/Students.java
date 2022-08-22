package 特殊操作流;

import java.io.Serializable;

public class Students implements Serializable {
    private static final long serialVersionUID = 42L; //解决修改对象属性后报错    //解决反序列化将导致InvalidClassException
    private transient int age;      //用于某个数据类型不参与实例化
    private String name;
    private String address;

    public Students() {

    }

    public Students(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
