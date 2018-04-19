import java.util.function.BiFunction;

public class bigbinary {
    public static void main(String args[]){
        student s=new student(85);
        Sex sex=new Sex('s');
        String str=null;
        str=compute(s,sex,(s1,sex1)->""+s1.getScore()+" "+sex1.getSex());
        System.out.println(str);

    }
    public static <T,U,R> R compute(T t,U u,BiFunction<T,U,R> b){
        return b.apply(t,u);
    }
}

class student{
    private int score;

    public student(int score){this.score=score;}
    public int getScore() {
        return score;
    }
}

class Sex{
    private char sex;

    public Sex(char s){this.sex=s;}
    public char getSex() {
        return sex;
    }
}