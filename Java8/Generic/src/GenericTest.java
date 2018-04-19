import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {
        Test<String> test=new Test<String>("aa");
        System.out.println(test.getData());
        test.setData("bb");
        System.out.println(test.getData());

        Test<Integer> test1=new Test<Integer>(1);
        System.out.println(test1.getData());
        test1.setData(2);
        System.out.println(test1.getData());

        System.out.println(test.getClass().getName());
        System.out.println(test1.getClass().getName());

        Test<MyType> test2=new Test<MyType>(new MyType(1));
        test2.setData(new MyType(2));
        System.out.println(test2.getClass().getName());
        MyType myType=null;
        myType=test2.getData();
        System.out.println(myType.getData());

        show(test);
        show(test1);
        show(test2);
    }

    public static void show(Test<?> obj){
        System.out.println(obj.getData());
    }
}

// 自定义的泛型类
class Test<T>{
    private T data; // 定义泛型成员变量

    public Test(T data){
        this.data=data;
    }

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data=data;
    }

    public static <T> T showTest(T t){ // 主要一定要写<T>!!!
        return t;
    }
}

// 自定义类型变量
class MyType{
    private int data;

    public MyType(int data){
        this.data=data;
    }
    public void setData(int data){
        this.data=data;
    }

    public int getData(){
        return data;
    }

    @Override
    public String toString(){
        return "data的值为"+data;
    }
}