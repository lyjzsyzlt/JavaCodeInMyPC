package consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class consumerTest {
    public static void main(String args[]){
        List<String> list=new ArrayList<>(Arrays.asList("a","b","c"));
        forEach(list,(String s)->System.out.println(s));//消费的形式是输出List中的每一个元素
        //forEach(list,(String s)->System.out.println(s+s));
    }

    public static <T> void forEach(List<T> list, Consumer<T> c){
        for(T t:list){
            c.accept(t);
        }
    }
}
