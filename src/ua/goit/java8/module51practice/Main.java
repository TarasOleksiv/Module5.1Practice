package ua.goit.java8.module51practice;

/**
 * Created by Taras on 29.07.2017.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static final int WIDTH = 900;
    public static final int HEIGHT = 825;
    public static final int MARGIN = 100;   //нижнє та верхнє поле

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        primaryStage.setTitle("Малювання");

        GraphicInterface graphicInterface = new GraphicInterface(primaryStage);

    }

    public static void main(String[] args) {
        launch(args);
    }

}