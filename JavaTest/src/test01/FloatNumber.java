package test01;

/**
 * Created by 82661 on 2016/9/29.
 */
public class FloatNumber {
    private int son;
    private int mother;

    public int getSon() {
        return son;
    }

    public void setSon(int son) {
        this.son = son;
    }

    public int getMother() {
        return mother;
    }

    public void setMother(int mother) {
        this.mother = mother;
    }

    public FloatNumber(int son, int mother) {
        this.son = son;
        this.mother = mother;
    }
    public FloatNumber multWithOther(FloatNumber obj){
        return new FloatNumber(this.son * obj.getSon(), this.mother * obj.getMother());
    }

    @Override
    public String toString() {
        return this.son + "/" + this.mother;
    }
    public static void main(String [] args){
        FloatNumber floatNumber = new FloatNumber(1, 2);
        FloatNumber floatNumber1 = new FloatNumber(5, 3);
        System.out.println(floatNumber.toString() + " * " +
                floatNumber1.toString() + " = "  + floatNumber.multWithOther(floatNumber1));
    }
}
