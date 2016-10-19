package test03.demo2;

/**
 * Created by 82661 on 2016/10/18.
 */
public class Undergraduate extends Student{
    String academy;
    String department;

    public static void main(String[] args) {
        Student s = new Student();
        s.setData("张三", 1);
        s.print();
        Undergraduate u = new Undergraduate();
        u.setData("李四", 2);
        u.academy = "计算机学院";
        u.department = "计算机科学与技术";
        System.out.print(u.name+", "+u.number+", "+u.academy+", "+u.department);

    }
}