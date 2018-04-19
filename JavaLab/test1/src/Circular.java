public class Circular {
    /*
    圆锥类
     */
    double radius; // 半径
    double height; // 高
    double getArea(){
        double area=1.0/3*3.1415926*radius*radius*height;
        return area;
    }
}
