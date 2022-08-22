import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream练习 {
    public static void main(String[] args) {
        //有两个集合，男演员集合和女演员集合
        //1 男演员要名字三个字的前三人
        //2 女演员只要姓林的，不要第一个
        //在合并两个集合
        //把流创建演员对象
        String [] arr ={"无心","王祖贤","吴彦祖","张翰","刘洋","郭德纲","彭于晏"};
        String [] arr2 ={"林心","林龙","林青霞","张子枫","汤唯","刘佳怡","林林"};
        List<String> man = Arrays.asList(arr);  //男演员集合
        List<String> woman = Arrays.asList(arr2);   //女演员
        /*////1 男演员要名字三个字的前三人
        Stream<String> limit = man.stream().filter(s -> s.length() == 3).limit(3);
        //2 女演员只要姓林的，不要第一个
        Stream<String> skip = woman.stream().filter(s -> s.startsWith("林")).skip(1);
        //集合合并
        Stream<String> concat = Stream.concat(limit, skip);
        //把流创建演员对象
        concat.map(actor::new).forEach(s-> System.out.println(s.getName()));*/

       //简写方式
        Stream.concat(man.stream().filter(s -> s.length() == 3).limit(3),woman.stream().
        filter(s -> s.startsWith("林")).skip(1)).map(actor::new).forEach(s-> System.out.println(s.getName()));

        //把流里的内容存进集合并且遍历
        System.out.println();
        Stream<String> limit = man.stream().limit(5);
        List<String> list = limit.collect(Collectors.toList());
        list.forEach(System.out::println);

    }
}
