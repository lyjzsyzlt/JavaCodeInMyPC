
public class Triangle {
    // 三条边
    double a;
    double b;
    double c;

    boolean isTriangle(){
        // 把三条边进行排序，两边之和大于第三边，两边之差小于第三边
        double temp;
        if(a<b){
            temp=a;
            a=b;
            b=temp;
        }
        if(a<c){
            temp=a;
            a=c;
            c=temp;
        }
        if(b<c){
            temp=b;
            b=c;
            c=temp;
        }

        //System.out.println("a="+a+"  b="+b+"  c="+c);
        if((b+c>a)&&(a-c)<b)
            return true;
        else
            return false;
    }
}

class Test1{
    public static void main(String[] args) {
        Triangle triangle=new Triangle();
        triangle.a=6;
        triangle.b=8;
        triangle.c=10;
        System.out.println("是否能构成三角形："+triangle.isTriangle());
    }
}
