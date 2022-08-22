package work;
//题目：有 1 、 2 、 3 、 4 四个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
public class work4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int k = 1; k <= 4; k++) {
                    if (i != j && j != k && k != i) {
                        int num = i + j * 10 + k * 100;
                        System.out.println(num);
                    }
                }
            }
        }
    }
}
