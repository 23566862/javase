package ZiDingYiYiChang;

public class techeah  {
    public void panduan (int a) throws ZiDingYi{
        if(a<0 ||  a>100){
            throw new ZiDingYi();
        }else{
            System.out.println("分数正确");
        }
    }
}
