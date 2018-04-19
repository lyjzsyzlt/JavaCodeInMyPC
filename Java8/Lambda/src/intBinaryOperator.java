import java.util.function.IntBinaryOperator;

public class intBinaryOperator {
    public static void main(String args[]){
        System.out.println(add(2,3,(a,b)->a+b));//(a,b)->a+b) 这个参数的意义就是一个行为，告诉IntBinaryOperator这个接口，applyAsInt该怎么做
        System.out.println(add(2,3,(a,b)->a*b));
    }

    public static  int add(int a,int b,IntBinaryOperator i){
        return i.applyAsInt(a,b);
    }
}
