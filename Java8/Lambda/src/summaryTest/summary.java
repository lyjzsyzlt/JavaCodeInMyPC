package summaryTest;
import java.util.function.DoubleFunction;
import java.util.function.IntFunction;
import java.util.function.Function;
public class summary {
    public static void main(String[] args) {
        double s2=sum(1,1,(double i)->i/2);
        System.out.println(s2);
    }

    /*public static int sum(int a, int b, IntFunction<Integer> d){
        int count= 0;
        for(int i=a;i<=b;i++){
            count+=d.apply(i);
        }
        return count;
    }*/
    public static double sum(int a, int b, DoubleFunction<Double> d){
        double count= 0;
        for(int i=a;i<=b;i++){
            count+=d.apply(i);
        }
        return count;
    }
}

class A{

}