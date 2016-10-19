package test01;

/**
 * Created by 82661 on 2016/9/29.
 */
public class Point3D extends Point {
    private int z;

    public int getZ() {
        return z;
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public float getDistance(Point3D point) {
        return (float) Math.sqrt(Math.pow((this.getX() - point.getX()), 2)
                + Math.pow((this.getY() - point.getY()), 2)
                + Math.pow((z - point.getZ()), 2));
    }
}
