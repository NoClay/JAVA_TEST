package test01;

/**
 * Created by 82661 on 2016/9/29.
 */
public class Line {
    private Point start;
    private Point end;

    public Line(int sx, int sy, int ex, int ey) {
        this.start = new Point(sx, sy);
        this.end = new Point(ex, ey);
    }
    public float length(){
        return (float) Math.sqrt(Math.pow((start.getX() - end.getX()), 2)
                + Math.pow((start.getY() - end.getY()), 2));
    }
    public boolean isHorizon(){
        return (start.getX() - end.getX()) == 0;
    }
    public boolean isVertical(){
        return (start.getY() - end.getY()) == 0;
    }
    public float tanLine(){
        return (float) ((start.getY() - end.getY())/(start.getX() - end.getX()));
    }
    public Point halfPoint(){
        return new Point((int)(start.getX() + end.getX()) / 2, (int)(start.getY() + end.getY()) / 2);
    }

    public boolean isEqual(Line line){
        return this.length() == line.length();
    }
    public static void main(String [] args){
        Line line1 = new Line(1, 2, 3, 4);
        Line line = new Line(2, 3, 4, 5);
        System.out.println("line1 的长度 = " + line1.length()
                + "\nline1 是否水平" + line1.isHorizon()
                + "\nline1 是否垂直" + line1.isVertical()
                + "\nline1 的斜率" + line1.tanLine()
                + "\nline1 的中点是" + line1.halfPoint().toString()
                + "\nline1 和line 是否相等" + line1.isEqual(line)
        );
    }
}
