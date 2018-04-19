public class NarcissusNum {
    // 求水仙花数

    public static void main(String[] args) {
        for(int i=100;i<1000;i++){
            int a=i/100; // 百位数
            int b=(i-a*100)/10; // 十位数
            int c=(i-a*100-b*10); // 个位数
            if(a*a*a+b*b*b+c*c*c==i)
                System.out.println(i);
        }
    }
}
