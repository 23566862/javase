import java.util.*;
import java.util.stream.Stream;

public class stream流 {
    public static void main(String[] args) {
       //stream流的常见生成方式
        //1 Collection集合生成流
        ArrayList<String> al1 =new ArrayList<>();
        Stream<String> stream = al1.stream();

        Set<String> set = new TreeSet<>();
        Stream<String> stream1 = set.stream();

        //2 Map集合间接生成流
        Map<String,Integer> map =new HashMap<>();
        //得到键的stream流
        Set<String> set1 = map.keySet();
        Stream<String> stream2 = set1.stream();

        //值对应的stream流
        Collection<Integer> values = map.values();
        Stream<Integer> stream3 = values.stream();

        //map键值对整体stream流
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Stream<Map.Entry<String, Integer>> stream4 = entries.stream();

        //3 数组生成流,通过of方法得到
        Stream<String> stringStream = Stream.of("12", "14", "44");


        //stream流的中间操作
        //filter
        //要求筛选姓张和姓名长度为3
        ArrayList<String> al =new ArrayList<>();
       al.add("张曼玉");
       al.add("张无忌");
       al.add("无敌");
       al.add("好迪");
       al.add("张嘉文");
       al.add("张文");
       al.stream().filter(s->s.startsWith("张")).filter(s->s.length() ==3).forEach(System.out::println);
        System.out.println();
       //limit截取前面数据
        Stream<String> limit = al.stream().limit(3);
        System.out.println();
        //skip跳过前面数据
        Stream<String> skip = al.stream().skip(1);

        //concat，合并两个流
        //Stream.concat(limit,skip).forEach(System.out::println);
        System.out.println();
        System.out.println("distinct方法去掉重复元素");
        //distinct()合并流没有重复的数据
        /*distinct()
        返回由该流的不同元素（根据 Object.equals(Object) ）组成的流*/
        Stream.concat(limit,skip).distinct().forEach(System.out::println);

        //sorted流的排序方法
        //1 自然排序
        System.out.println();
        al.stream().sorted().forEach(System.out::println);
        // 2 自己排序
        System.out.println();
        al.stream().sorted((s1,s2)->s1.length()-s2.length()).forEach(System.out::println);

        //map方法类型转换
        String [] arr ={"45","33","66","66","3490","33"};
        List<String> list = Arrays.asList(arr);
        //通过map集合转换集合类型，string转int并且从小到大排序，在求总和
        System.out.println();
        int sum = list.stream().distinct().mapToInt(Integer::parseInt).sorted().sum();
        System.out.println("总和为："+sum);


    }
}
