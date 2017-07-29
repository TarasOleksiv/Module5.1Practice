package ua.goit.java8.module51practice;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ua.goit.java8.module51practice.task1.Point;
import ua.goit.java8.module51practice.task2.Line;
import ua.goit.java8.module51practice.task3.Triangle;
import ua.goit.java8.module51practice.task4.Fractal;

/**
 * Created by Taras on 29.07.2017.
 */
public class GraphicInterface {

    private Pane root = new Pane();
    private Line[] lines;
    private Triangle triangleOnTheScene;
    private Triangle[] fractalTriangles;

    public GraphicInterface(Stage primaryStage){
        graphicInterface();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
}

    private void graphicInterface(){
        Button generateLine = new Button();
        generateLine.setTranslateX(10);
        generateLine.setTranslateY(10);
        generateLine.setText("Намалювати лінії");
        generateLine.setOnMouseClicked(event -> {
            clearLines();
            drawLines();
        });

        Button clearLine = new Button();
        clearLine.setTranslateX(10);
        clearLine.setTranslateY(40);
        clearLine.setText("Стерти лінії");
        clearLine.setOnMouseClicked(event -> {
            clearLines();
        });

        Button createTriangle = new Button();
        createTriangle.setTranslateX(10);
        createTriangle.setTranslateY(90);
        createTriangle.setText("Намалювати трикутник");
        createTriangle.setOnMouseClicked(event -> {
            clearTriangle();
            drawTriangle();
        });

        Button clearTriangle = new Button();
        clearTriangle.setTranslateX(10);
        clearTriangle.setTranslateY(120);
        clearTriangle.setText("Стерти трикутник");
        clearTriangle.setOnMouseClicked(event -> {
            clearTriangle();
        });

        Label fractalDepthLabel = new Label("Глибина фракталу: ");
        fractalDepthLabel.setTranslateX(10);
        fractalDepthLabel.setTranslateY(170);

        TextField fractalDepth = new TextField();
        fractalDepth.setTranslateX(140);
        fractalDepth.setTranslateY(170);
        fractalDepth.setPrefWidth(50);
        fractalDepth.setText("40");

        Label fractalPercentOffsetLabel = new Label("Процентний відступ: ");
        fractalPercentOffsetLabel.setTranslateX(10);
        fractalPercentOffsetLabel.setTranslateY(200);

        TextField fractalPercentOffset = new TextField();
        fractalPercentOffset.setTranslateX(140);
        fractalPercentOffset.setTranslateY(200);
        fractalPercentOffset.setPrefWidth(50);
        fractalPercentOffset.setText("0.05");

        Button createFractal = new Button();
        createFractal.setTranslateX(10);
        createFractal.setTranslateY(230);
        createFractal.setText("Намалювати фрактал");
        createFractal.setOnMouseClicked(event -> {
            clearFractal();
            int depth = Integer.parseInt(fractalDepth.getText());
            float percentOffset = Float.parseFloat(fractalPercentOffset.getText());
            drawFractal(depth,percentOffset);
        });

        Button createFractalRecursion = new Button();
        createFractalRecursion.setTranslateX(10);
        createFractalRecursion.setTranslateY(260);
        createFractalRecursion.setText("Намалювати фрактал рекурсією");
        createFractalRecursion.setOnMouseClicked(event -> {
            clearFractal();
            int depth = Integer.parseInt(fractalDepth.getText());
            float percentOffset = Float.parseFloat(fractalPercentOffset.getText());
            drawFractalRecursion(depth,percentOffset);
        });

        Button clearFractal = new Button();
        clearFractal.setTranslateX(10);
        clearFractal.setTranslateY(290);
        clearFractal.setText("Стерти фрактал");
        clearFractal.setOnMouseClicked(event -> {
            clearFractal();
        });

        root.getChildren().addAll(generateLine, clearLine, createTriangle, clearTriangle,
                createFractal, clearFractal, createFractalRecursion,
                fractalDepthLabel, fractalDepth, fractalPercentOffsetLabel, fractalPercentOffset);
    }

    private void drawLines(){
        // малюєм лінію
        Point p1 = new Point(200,700);
        Point p2 = new Point(500,200);
        Line line = new Line(p1,p2);
        line.draw(root);

        // малюєм другу лінію від початку до точки поділу першох лінії червоним кольором
        //Line line1 = new Line(p1.getZero(),line.getPointOnLine(0.3f));
        Line line1 = new Line(p1,line.getPointOnLine(0.3f));
        line1.draw(root, Color.RED);
        lines = new Line[2];
        lines[0] = line;
        lines[1] = line1;
    }

    private void clearLines(){
        if (lines != null) {
            for (int i = 0; i < lines.length; i++){
                lines[i].clear(root);
            }
        }
    }

    private Triangle createTriangle(){
        Point p1 = new Point(300, 700);
        Point p2 = new Point(400,200);
        Point p3 = new Point(700,600);
        Triangle triangle = new Triangle(p1,p2,p3);
        return triangle;
    }

    private void drawTriangle(){
        Triangle triangle = createTriangle();
        triangle.draw(root);
        triangleOnTheScene = triangle;
    }

    private void clearTriangle(){
        if (triangleOnTheScene != null) {
            triangleOnTheScene.clear(root);
        }
    }

    private void drawFractal(int depth, float percentOffset){
        Fractal fractal = new Fractal(percentOffset,createTriangle());
        fractal.draw(depth,root);
        fractalTriangles = new Triangle[depth];
        fractalTriangles = fractal.getTriangles();
    }

    private void drawFractalRecursion(int depth, float percentOffset){
        Fractal fractal = new Fractal(depth,percentOffset,createTriangle());
        fractal.draw(depth,fractal.getTriangle(),root);
        fractalTriangles = new Triangle[depth];
        fractalTriangles = fractal.getTriangles();
    }

    private void clearFractal(){
        if (fractalTriangles != null && fractalTriangles.length > 0) {
            for (int i = 0; i < fractalTriangles.length; i++){
                fractalTriangles[i].clear(root);
            }
        }
    }
}
