package Lambda.src.Lambda;

import java.util.*;

public class 集合遍历和排序Lambda {
    public static void main(String[] args) {
    map();
    }
    public static void map(){
        Map<String,String> map =new HashMap<String,String>();
        map.put("c","柳岩");
        map.put("dfds","迪丽热巴");
        map.put("as","欧阳娜娜");
        map.put("0dd","张子枫");
        map.put("ss","谭松韵");
        Set<String> set =map.keySet();      //获取键的集合
        List<Map.Entry<String,String>> al =new ArrayList<Map.Entry<String,String>>(map.entrySet());
       ///遍历方式三lambda
        set.forEach(a-> System.out.println(a+","+map.get(a)));
        System.out.println();
        //使用lambda简化compa接口
        Collections.sort(al,(Map.Entry<String,String> o1,Map.Entry<String,String> o2)->o1.getValue().compareTo(o2.getValue()));
       /* for (Map.Entry<String,String> mp:al){
            System.out.println(mp.getKey()+","+mp.getValue());
        }*/
       //遍历
        al.forEach(o1-> System.out.println(o1.getKey()+","+o1.getValue()));
        System.out.println();
        al.forEach(System.out::println);

    }
}
