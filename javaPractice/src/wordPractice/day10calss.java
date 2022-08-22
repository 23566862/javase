package javaPractice.src.wordPractice;

import java.io.Serializable;

public class day10calss implements Serializable {
    private static final long serialVersionUID =42L;//解决修改对象属性后报错
    private String name;
    private String sex;
    private int age;

    public day10calss() {
    }

    public day10calss(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
