package ua.goit.java8.module51practice.task3;

import javafx.scene.layout.Pane;
import ua.goit.java8.module51practice.task1.Point;
import ua.goit.java8.module51practice.task2.Line;

/**
 * Created by Taras on 29.07.2017.
 */
public class Triangle {
    private Line l1;
    private Line l2;
    private Line l3;

    public Triangle(Point p1,Point p2, Point p3){
        l1 = new Line(p1,p2);
        l2 = new Line(p2,p3);
        l3 = new Line(p3,p1);
    }

    public void draw(Pane root){
        l1.draw(root);
        l2.draw(root);
        l3.draw(root);
    }

    public void clear(Pane root){
        l1.clear(root);
        l2.clear(root);
        l3.clear(root);
    }

    public Line getL1(){
        return l1;
    }

    public Line getL2(){
        return l2;
    }

    public Line getL3(){
        return l3;
    }
}
