package test02;

/**
 * Created by 82661 on 2016/9/29.
 */
public class Example {
    public static void main(String args[]) {
        A.b = 100;
        A.inputB();
        A cat = new A();
        A dog = new A();
        cat.setA(200);
        cat.setB(400);
        dog.setA(150);
        dog.setB(300);
        cat.inputA();
        cat.inputB();
        dog.inputA();
        dog.inputB();
    }
}

class A {
    float a;
    static float b;

    public void setA(float a) {
        this.a = a;
    }

    public void setB(float b) {
        this.b = b;
    }

    float getA() {
        return a;
    }

    float getB() {
        return b;
    }

    void inputA() {
        System.out.println(a+b);
    }

    static void inputB() {
        System.out.println(b);
    }
}

