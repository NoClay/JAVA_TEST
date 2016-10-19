package test02;

/**
 * Created by 82661 on 2016/9/29.
 */
public class AreaAndLength {
    public static void main(String[] args) {
        double length, area;
        Circle circle = null;
        circle = new Circle(16);
        Triangle triangle = new Triangle(14, 12, 10);
        Lader lader = new Lader(15, 2, 16);
        length = circle.getPerimeter();
        System.out.println("圆的周长:" + length);
        area = circle.getArea();
        System.out.println("圆的面积:" + area);
        length = triangle.getLength();
        System.out.println("三角形的周长:" + length);
        area = triangle.getArea();
        System.out.println("三角形的面积:" + area);
        area = lader.getArea();
        System.out.println("梯形的面积:" + area);
        triangle.setABC(12, 34, 1);
        area = triangle.getArea();
        System.out.println("三角形的面积:" + area);
        length = triangle.getLength();
        System.out.println("三角形的周长:" + length);
    }
}

/**
 * 三角形类，用于描述三角形
 */
class Triangle {
    double sideA, sideB, sideC, area, length;
    boolean boo;

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public Triangle(double sideA, double sideB, double sideC) {
        setABC(sideA, sideB, sideC);
    }

    public double getLength() {
        if (boo) {
            length = sideA + sideB + sideC;
            return length;
        } else {
            System.out.println("不是一个三角形,不能计算面积");
            return 0;
        }
    }

    public double getArea() {
        if (boo) {
            double p = (sideA + sideB + sideC) / 2.0;
            area = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
            return area;
        } else {
            System.out.println("不是一个三角形,不能计算面积");
            return 0;
        }
    }

    public void setABC(double a, double b, double c) {
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
        boo = false;
        if (sideA + sideB > sideC
                && sideA + sideC > sideB
                && sideB + sideC > sideA) {
            boo = true;
        } else {
            boo = false;
        }
    }
}

class Lader {
    double above, bottom, height, area;

    public Lader(double above, double bottom, double height) {
        this.above = above;
        this.bottom = bottom;
        this.height = height;
    }

    public double getArea() {
        area = (above + bottom) * height / 2;
        return area;
    }
}

class Circle {
    double radius, perimeter, area;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getPerimeter() {
        perimeter = 2 * Math.PI * radius;
        return perimeter;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        System.out.println("半径已修改为" + radius
         + "\n修改后周长" + getPerimeter()
         + "\n修改后面积" + getArea());
    }

    public double getArea() {
        area = Math.PI * radius * radius;
        return area;
    }
}

