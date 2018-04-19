import java.util.Scanner;

public class Compute {
    /*
    从键盘输入两个浮点数，输出他们的四则运算结果
     */
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        double a=in.nextFloat();
        double b=in.nextFloat();
        System.out.println("a+b="+(a+b));
        System.out.println("a-b="+(a-b));
        System.out.println("a*b="+(a*b));
        System.out.println("a/b="+(a/b));
    }
}
