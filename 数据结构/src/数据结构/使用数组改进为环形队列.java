package 数据结构;

import java.util.Scanner;

public class 使用数组改进为环形队列 {
    /*缺点：数组只能添加一次数据，取出数据之后头部+1前面空间无法使用
    * 改进：使用环形队列，循环使用*/
    public static void main(String[] args) {
        ArrayQueue ar =new ArrayQueue(3);//实际只能添加2个数据，一个为预留有位置用于判断是否为满
       char choie =' ';
        Scanner sc =new Scanner(System.in);
        while(true){
            System.out.println("----------------------------");
            System.out.println("a 显示队列");
            System.out.println("b 添加数据到队列");
            System.out.println("c 从队列取出数据");
            System.out.println("d 显示对头数据");
            System.out.println("e 退出");
            System.out.println("----------------------------");
            choie =sc.next().charAt(0);
            switch (choie){
                case 'a':
                    ar.showqueue();
                    break;
                case 'b':
                    System.out.println("请输入要添加的数据：");
                    int quueue =sc.nextInt();
                    ar.addqeue(quueue);
                    break;
                case 'c':
                    int num =ar.getqueue();
                    System.out.println("取出的数据是："+num);
                    break;
                case 'd':
                    System.out.println(ar.headqueue());
                    break;
                case 'e':
                    System.exit(0);
                    break;
                default:{
                    System.out.println("选择错误");
                }
            }
        }

    }

    //创建一个模拟实现队列的类
    public static class ArrayQueue{
        private int maxsize;//数组的最大容量
        private int front=0;  //队列头
        private int rear=0;   //队列尾
        private int[] arr;  //存放数据
        public ArrayQueue(int maxsize){
            this.maxsize=maxsize;
            arr =new int[this.maxsize];
        }
        //判断数队列是否尾满
        public boolean isFull(){
            return (rear+1)%maxsize==front;
        }
        //判断队列是否为空
        public boolean isEmpty(){
            return front ==rear;
        }
        //添加数据到队列
        public void addqeue(int shuju){
            //先判断数据是否为满
            if (isFull()){
                System.out.println("队列为满不能添加");
            }else{
                arr[rear] =shuju;
                //需要考虑前面是否有空的数据
                rear=(rear+1)%maxsize;
            }
        }

        //队列删除数据
        public int  getqueue(){
        //判断是否为空
            int num =0;
            if (isEmpty()){
                System.out.println("队列为空不能删除");
            }else{

                //System.out.println(front);
                num=arr[front];
                front=(front+1)%maxsize;    //队列头部+1
            }

            return num;
        }

        //遍历所有队列
        public void showqueue(){
           if ( isEmpty()){
               System.out.println("队列为空无法遍历");
           }else{
               //从头部front开始遍历，遍历个数为有效数据个数
               for (int i = front; i <front+numdata() ; i++) {
                   System.out.println("arr["+i%maxsize+"]"+"="+arr[i%maxsize]);
               }
           }
        }

        //显示头队列的数据
        public int headqueue(){
            if ( isEmpty()){
                System.out.println("队列为空");
                return 0;
            }
            return arr[front];
        }

        public int numdata(){
                return (rear+maxsize-front)%maxsize;
        }
    }
}
