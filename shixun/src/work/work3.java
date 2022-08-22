package work;
/*3、猴子吃桃问题。猴子第一天摘下若干个桃子，当时就吃了一半，还不过瘾，
        就又吃了一个。第二天又将剩下的桃子吃掉一半，又多吃了一个。以后每天都吃前一天剩下的一半零一个。
        到第 10 天在想吃的时候就剩一个桃子了,求第一天共摘下来多少个桃子*/
public class work3 {
    public static void main(String[] args) {
        int count = 1;  //定义的是第10天的桃子数量，根据题目意思，每天/2-1，要求第一天就反过来先+1*2
        for (int i = 0; i < 10; i++) {
            count = (count + 1) * 2;
        }
        System.out.println(count);
    }


}


