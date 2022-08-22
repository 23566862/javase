package javaPractice.src.wordPractice;

import java.util.ArrayList;

public class CollectionPractice {
    public static void main(String[] args) {
        //work3();
        //work4();
        work5();
    }

    public static void work3() {
        //三、定义一个方法，要求此方法把int数组转成存有相同元素的集合(集合里面的元素是Integer)，并遍历
        int[] arr = {12, 12, 66, 77, 88, 10, 55, 77};
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            al.add(arr[i]);
        }
        for (Integer a : al) {
            System.out.println(a);
        }
    }
    public static void work4(){
      /*四、定义一个集合，
    并把集合(集合里面的元素是Integer)
    转成存有相同元素的数组，并将结果输出在控制台。（
    可以使用Object[] 数
    组类型接收转换的数组）*/
        ArrayList<Integer> al = new ArrayList<>();
        al.add(45);
        al.add(42);
        al.add(45);
        al.add(4535);
        al.add(466);
        al.add(4510);
        Object [] ob =al.toArray();
        for (int i = 0; i <ob.length ; i++) {
            System.out.println(ob[i]);
        }


    }
    public static void work5(){
        //要求使用contains()方法判断al集合里面是否包含s
        ArrayList<String> al = new ArrayList<>();
        al.add("s");
        al.add("fff");
        al.add("www");
        al.add("xxx");
        al.add("xiaoe");
        if(al.contains("s")){
            System.out.println("集合里有s");
        }else{
            System.out.println("没有s");
        }
    }

}
