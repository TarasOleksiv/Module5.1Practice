package ua.goit.java8.module51practice.task4;

import javafx.scene.layout.Pane;
import ua.goit.java8.module51practice.task1.Point;
import ua.goit.java8.module51practice.task3.Triangle;

/**
 * Created by Taras on 29.07.2017.
 */
public class Fractal {
    private int depth;  //глубина фрактала (кол-во итераций отрисовки)
    private float percentOffset;    //отступ от начала линии предыдущей итерации отрисовки
    private Triangle triangle;
    private Triangle[] triangles;

    public Fractal(int depth, float percentOffset, Triangle triangle){
        this.depth = depth;
        this.percentOffset = percentOffset;
        this.triangle = triangle;
        triangles = new Triangle[this.depth];
    }

    public Fractal(float percentOffset, Triangle triangle){
        this.percentOffset = percentOffset;
        this.triangle = triangle;
    }

    public void draw(int depth, Pane root){
        this.depth = depth;
        triangles = new Triangle[depth];
        for (int i = 0; i < depth; i++){
            triangles[i] = triangle;
            triangle.draw(root);
            triangle = getNextTriangle(triangle,percentOffset);
        }
    }

    public void draw(int depth, Triangle triangleRecursion, Pane root){

        if (depth == 0) return;
        triangleRecursion.draw(root);
        triangles[depth-1] = triangleRecursion;
        draw(depth-1,getNextTriangle(triangleRecursion,percentOffset),root);

    }

    private Triangle getNextTriangle(Triangle triangle, float percentOffset){
        Point p1 = triangle.getL1().getPointOnLine(percentOffset);
        Point p2 = triangle.getL2().getPointOnLine(percentOffset);
        Point p3 = triangle.getL3().getPointOnLine(percentOffset);
        return new Triangle(p1,p2,p3);
    }

    public void clear(Pane root){
        if (triangles != null && triangles.length > 0) {
            for (int i = 0; i < triangles.length; i++) {
                triangles[i].clear(root);
            }
        }
    }

    public int getDepth(){
        return depth;
    }

    public float getPercentOffset(){
        return percentOffset;
    }

    public Triangle getTriangle(){
        return triangle;
    }

    public Triangle[] getTriangles(){
        return triangles;
    }

    public void setDepth(int depth){
        this.depth = depth;
    }

    public void setPercentOffset(float percentOffset){
        this.percentOffset = percentOffset;
    }

    public void setTriangle(Triangle triangle){
        this.triangle = triangle;
    }
}
