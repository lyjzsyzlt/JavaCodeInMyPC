package function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class map {
    public static void main(String args[]){
        List<String> list=new ArrayList<>(Arrays.asList("ab","cd","aab"));
        List<Integer> res=new ArrayList<Integer>();
        // 统计每个字符串中的字符a的个数，返回到res中
        res=map(list,(String s)->{
            char [] str=s.toCharArray();
            int count=0;
            for(char c:str){
                if(c=='a'){count++;}
            }
            return count;
        });

        for(Integer i:res){
            System.out.println(i);
        }
    }

    public static <T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> results=new ArrayList<R>();
        for(T t:list){
            results.add(f.apply(t));
        }
        return results;
    }
}
