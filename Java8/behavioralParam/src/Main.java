import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]){
        Apple a1=new Apple(151,"red");
        Apple a2=new Apple(149,"green");
        List<Apple> appleList=new ArrayList<Apple>();
        appleList.add(a1);
        appleList.add(a2);

        prettyPrintApple(appleList,new AppleFancyFormatter());
        prettyPrintApple(appleList,new AppleSimpleFormatter());
    }
    public static void prettyPrintApple(List<Apple> inventory,AppleToString p){
        for(Apple apple:inventory){
            String output=p.accept(apple);
            System.out.println(output);
        }
    }
}
