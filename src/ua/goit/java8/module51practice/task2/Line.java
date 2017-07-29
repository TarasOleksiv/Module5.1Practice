package ua.goit.java8.module51practice.task2;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import ua.goit.java8.module51practice.task1.Point;

/**
 * Created by Taras on 29.07.2017.
 */
public class Line {
    private Point p1;
    private Point p2;
    private javafx.scene.shape.Line lineFx;

    public Line(Point p1,Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public double calcLength(){
        return p1.calcLength(p2);
    }

    public Point getPointOnLine(float percent){
        double x;
        double y;
        if (percent >= 0 && percent <= 1){
            x = (p2.getX() - p1.getX()) * percent + p1.getX();
            y = (p2.getY() - p1.getY()) * percent + p1.getY();
        } else {
            x = p2.getX();
            y = p2.getY();
        }
        return new Point(x,y);
    }

    public void draw(Pane root){
        lineFx = new javafx.scene.shape.Line(p1.getX(),p1.getY(),p2.getX(),p2.getY());
        root.getChildren().addAll(lineFx);
    }

    public void draw(Pane root, Color color) {
        lineFx = new javafx.scene.shape.Line(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        lineFx.setStroke(color);
        root.getChildren().addAll(lineFx);
    }

    public void clear(Pane root){
        if (lineFx != null){
            root.getChildren().removeAll(lineFx);
        }
    }

    public Point getP1(){
        return p1;
    }

    public Point getP2(){
        return p2;
    }
}
