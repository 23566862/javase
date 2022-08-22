import java.util.*;

public class 线程安全的类 {
    public static void main(String[] args) {
        StringBuilder sb =new StringBuilder();  //用法相同，线程不安全
        StringBuffer stringBuffer =new StringBuffer();//线程安全，可变的字符序列,字符串拼接

        Vector<String> vc =new Vector<>();  //extends AbstractList<E>
        ArrayList<String> al =new ArrayList<>();// Vector是同步的。 如果不需要线程安全的实现，建议使用ArrayList代替Vector 。

        Hashtable<String,String> hb =new Hashtable<>();//implements Map<K,V>,
        // 该类实现了一个哈希表，它将键映射到值。 任何非null对象都可以用作键值或值。
        Map<String,String> mp =new HashMap<>();//Hashtable是同步的。 如果不需要线程安全的实现，建议使用HashMap代替Hashtable


        //也可以使用collections里的方法
        // synchronizedList(List<T> list)//返回由指定列表支持的同步（线程安全）列表。
        //static <K,V> Map<K,V> synchronizedMap(Map<K,V> m) 返回由指定地图支持的同步（线程安全）映射。
        List<String> lish = Collections.synchronizedList(new ArrayList<String>());
        Map<String, String> map = Collections.synchronizedMap(mp);
    }
}
