public class PrintInfo {
    public static void main(String[] args) {
        Student student=new Student("E21514048","吕永杰","男",180,70);
        System.out.println("学号："+student.ID);
        System.out.println("姓名："+student.Name);
        System.out.println("性别："+student.Sex);
        System.out.println("身高："+student.Height+"CM");
        System.out.println("体重："+student.Weight+"KG");
    }
}

/*
学生类
 */
class Student{
     String ID; // 学号
     String Name; // 姓名
     String Sex; // 性别
     int Height; // 身高
     float Weight; // 体重

    public Student(String ID,String Name,String Sex,int Height,float Weight){
        this.ID=ID;
        this.Name=Name;
        this.Sex=Sex;
        this.Height=Height;
        this.Weight=Weight;
    }
}
