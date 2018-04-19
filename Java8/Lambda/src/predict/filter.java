package predict;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class filter {
    public static void main(String args[]){
        List<Integer> list=new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> res=filter(list,(Integer i)->i>2);//test的条件为i>2

        for(Integer i:res){
            System.out.println(i);
        }
    }
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> results =new ArrayList<T>();
        for(T s:list){
            if(p.test(s)){
                results.add(s);
            }
        }
        return results;
    }
}
