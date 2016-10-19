package test01;

/**
 * Created by 82661 on 2016/9/29.
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public float getDistance(Point point){
        return (float) Math.sqrt(Math.pow((x - point.getX()), 2)
                + Math.pow((y - point.getY()), 2));
    }

}
