package 数据结构;

public class 五子棋稀疏数组 {

    public static void main(String[] args) {
         int sum=0;
        //初始二维数组棋盘 1表示黑子 2表示篮子
        int chessArr[][] = new int[11][11];
        //给二维数组输入黑子和篮子的值
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[5][4] =1;
        //遍历原始二位数组
        System.out.println("原始二维数组");
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j <11 ; j++) {
                System.out.print(chessArr[i][j]+"\t");
            }
            System.out.println();
        }
        //1 遍历得到有效数据，不为0的数据
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j <11 ; j++) {
               if(chessArr[i][j]!=0){
                   sum++;
               }
            }
        }

        //2 创建对应的稀疏数组
        int sparseArr [][] =new int[sum+1][3];
        sparseArr[0][0] =11;
        sparseArr[0][1] =11;
        sparseArr[0][2] =sum;
       //使用for遍历得到二维数组数据
        int count =1;
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j <11 ; j++) {
                if(chessArr[i][j]!=0){
                  sparseArr[count][0]=i;//原始二维数组不为0的行数
                  sparseArr[count][1]=j;//原始二维数组不为0的列数
                  sparseArr[count][2]=chessArr[i][j];//原始二维数组不为0的值
                  count++;
                }
            }
        }

        System.out.println();
        System.out.println("原始二维数组转稀疏数组");
        for (int row[]:sparseArr){
            for (int date:row){
                System.out.print(date+"\t");
            }
            System.out.println();
        }

        //稀疏数组转换为原始二维数组
        int chessArr2[][] =new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i <sparseArr.length ; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }

        System.out.println("恢复后的二位数组");
        for (int row[]:chessArr2){
            for (int date:row){
                System.out.print(date+"\t");
            }
            System.out.println();
        }
    }
}
