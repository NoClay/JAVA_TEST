package Test;

/**
 * Created by NoClay on 2016/12/22.
 */

//定义一个长方体类,该类拥有长、宽、高三个属性，及计算体积的函数；
//        定义一个子类继承该长方体类，需新增加成员变量：重量，并增加计算长方体表面积的函数。
//
//        输出格式:
//
//        请输出调用的构造参数，新增成员变量值的显示，计算长方体表面积的函数。
//
//        输出样例:
//
//        在这里给出相应的输出。例如：
//        此时调用第一个构造函数
//        此时调用第二个构造函数
//        此时调用第三个构造函数
//        将对象作为参数传递，height=3.0
//        3.0
//        2.0
//        Volume of newCuboid is3000.0
//        Weight of newCuboid is34.3
//        superficialarea of newCuboid is1300.0
public class Rectangle {
    float x;
    float y;
    float z;

    public float getV(){
        return x * y * z;
    }
}
class TestRectangle extends Rectangle{
    float weight;
    public float getArea(){
        return 2 * (x * y + x * z + y * z);
    }

}
