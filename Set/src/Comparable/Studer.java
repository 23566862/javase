package Comparable;

public class Studer implements Comparable<Studer> {
    private String name;
    private int age;

    public Studer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Studer() {
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

    @Override
    public int compareTo(Studer s) {
        int num = this.age - s.age;      /* this.age =s1
                                           s.age =s          */
        int num2 = num == 0 ? this.name.compareTo(s.name) : num;                                  //s.age =s
        return num2;
    }
}
