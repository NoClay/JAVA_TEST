package test01;

/**
 * Created by 82661 on 2016/9/29.
 */
public class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
        this.width = this.height = 1;
    }

    public double getArea() {
        return width * height;
    }
    public double getPerimeter(){
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "矩形(" + width + "," + height + ')';
    }

    public boolean equals(Rectangle rectangle) {
        return this.getArea() == rectangle.getArea();
    }
    public static void main(String [] args){
        Rectangle rectangle = new Rectangle(1, 3);
        System.out.println(rectangle.toString()
         + "\n周长：" + rectangle.getPerimeter()
         + "\n面积：" + rectangle.getArea());
    }
}
