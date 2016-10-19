package test01;

/**
 * Created by 82661 on 2016/9/29.
 */
public interface GetArea {
    public double getArea();
}
class Circle implements GetArea{
    private int r;

    public Circle(int r) {
        this.r = r;
    }

    @Override
    public double getArea() {
        return Math.PI * r * r;
    }
}
class Rectangle2 implements GetArea{
    private int width;
    private int height;

    public Rectangle2(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}
