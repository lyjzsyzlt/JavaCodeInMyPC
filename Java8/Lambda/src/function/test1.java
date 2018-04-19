package function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test1 {
    public static void main(String args[]){
        List<Integer> weigths=new ArrayList<>(Arrays.asList(10,20,30,11));
        //List<Apple> apples=map.map(weigths,Apple::new);

        List<Apple> apples=map.map(weigths,(Integer weight)->new Apple(weight));
        for(Apple a:apples){
            a.display();
        }
    }

}
