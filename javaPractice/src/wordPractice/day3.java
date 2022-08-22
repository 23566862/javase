package javaPractice.src.wordPractice;

public class day3 {
    public static void main(String[] args) {
   // work3();
       // work4();
        work5();
    }
    public static void work3(){
//        打印1到100之内的整数，但数字中包含9的要跳过
//        2.每行输出5个满足条件的数，之间用空格分隔
        int count=0;
        for (int i = 0; i <100 ; i++) {
            if(i%10 ==9 || i/10 ==9){
                continue;
            }
            count++;
            System.out.print(i+" ");
            if(count%5 ==0){
                System.out.println();
            }
        }
    }
    public static void work4(){
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j <5 ; j++) {
                System.out.print("@ ");
            }
            System.out.println();
        }
    }
    public static void work5(){
        for (int i = 1; i <9 ; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print(i+"*"+j+"="+i*j+'\t');
            }
            System.out.println();
        }
    }
}
