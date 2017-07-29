package ua.goit.java8.module51practice.task1;

/**
 * Created by Taras on 21.07.2017.
 */
public class Point {
    private static final Point ZERO = new Point(0,0);
    private double x;
    private double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double calcLength(Point otherPoint){
        return Math.sqrt(Math.pow((x - otherPoint.x),2) + Math.pow((y - otherPoint.y),2));
    }

    public double calcLength(){
        return calcLength(ZERO);
    }

    public Point normalize(){
        return new Point(x/calcLength(),y/calcLength());
    }

    public static void main(String[] args) {
        Point point = new Point(100,300);
        Point point1 = point.normalize();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point getZero(){
        return ZERO;
    }
}
