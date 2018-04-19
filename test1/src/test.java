import java.util.HashMap;
import java.util.Hashtable;

public class test {
    public static void main(String args[]){
     A a=new A();
     a.print();
    }
}

class A{
    static String s;
    static {
        s="hello";
    }
    public A(){}
    public void print(){
        String str="helloworld";
        String s1="world";
        String s2=s+s1;
        System.out.println(s2==str);
    }
}

