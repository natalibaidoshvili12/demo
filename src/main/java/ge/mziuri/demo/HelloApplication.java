package ge.mziuri.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        Label label = new Label("Hello World");
        Button button = new Button("Hello World");
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);
        Scene scene = new Scene(stackPane, 320, 240);
        AtomicInteger counter = new AtomicInteger();
        button.setOnAction(event -> {
            System.out.println("Hello World " + counter.incrementAndGet());
        });
        stage.setX(100);
        stage.setY(100);
        stage.setWidth(320);
        stage.setHeight(240);
        stage.show();
        stage.setTitle("Hello!");
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}