package test01;

/**
 * Created by 82661 on 2016/9/29.
 */
public class B {
    int b;

    public B(int b) {
        this.b = b;
        System.out.println("b = " + b);
    }
}
class A extends B{
    int a;

    public A(int b, int a) {
        super(b);
        this.a = a;
        System.out.println("b = " + b + "a = " + a);
    }
    public static void main(String []args){
        A a = new A(1, 2);
    }
}
