import java.util.Scanner;

public class Cylinder {
    /*
    键盘输入圆柱体的底面半径和高，求该圆柱体的表面积和体积
     */
    private double radius; // 圆柱的底面半径
    private double height; // 圆柱的高

    public Cylinder(double r,double h){
        radius=r;
        height=h;
    }

    // 表面积
    public double getArea(){
        return 2*3.1415926*radius*radius+2*3.1415926*radius*height;
    }

    // 体积
    public double getVolume(){
        return 3.1415926*radius*radius*height;
    }
}

class Test2{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("输入圆柱底面半径：");
        double r=in.nextDouble();
        System.out.println("输入圆柱的高：");
        double h=in.nextDouble();

        Cylinder cylinder=new Cylinder(r,h);
        System.out.println("圆柱的表面积："+cylinder.getArea());
        System.out.println("圆柱的体积："+cylinder.getVolume());
    }
}
