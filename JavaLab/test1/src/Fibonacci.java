public class Fibonacci {
/*
计算斐波拉契数列
 */
    public  long getFib(int n){
        if(n==1||n==2)
            return 1;
        else
            return getFib(n-1)+getFib(n-2);
    }
    public static void main(String[] args) {
        Fibonacci f=new Fibonacci();
        for(int i=1;i<=20;i++) {
            System.out.print(f.getFib(i) + "\t\t");
            //每行4个
            if(i%4==0)
                System.out.println();
        }
    }
}
