package supplier;
import java.util.List;
import java.util.function.Supplier;
public class createObjects {
    public static void main(String args[]){

       Supplier<student> stu=()->new student(5);
       System.out.println(stu.get().getAge());

       student stu2=create(()->new student(6));
       System.out.println(stu2.getAge());

    }

    public static <T> T create(Supplier<T> S){
       return S.get();
    }
}

class student{
    public int getAge() {
        return age;
    }

    private int age;
    public student(int age){
        this.age=age;
    }
}
