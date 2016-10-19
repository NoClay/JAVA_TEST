package test03.demo2;

/**
 * Created by 82661 on 2016/10/18.
 */
public class Student {

    protected String name;
    protected int number;

    void setData(String m, int h){
        name = m;
        number = h;
    }

    void print(){
        System.out.println(name+", "+number);
    }
}
