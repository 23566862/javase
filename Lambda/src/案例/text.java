package 案例;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class text {
    public static void main(String[] args) {

       /* //lambda表达式
          impLambda((a)-> Integer.parseInt(a));
    //使用引用类方法改进
    impLambda(Integer::parseInt);*/
    impLambda(String::toUpperCase);

}
    public static void impLambda(Lambda e){
        String s =e.show("advbsmve");
        System.out.println(s);
    }


}
