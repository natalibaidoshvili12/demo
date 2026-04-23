package ge.mziuri.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class ButtonsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        Label label = new Label("Hello World");
        Button btn1 = new Button("Create Labels");
        Button btn2 = new Button("Remove Hello World");
        Button btn3 = new Button("Remove Hello Mziuri");
        Button btn4 = new Button("Replace World");
        Button btn5 = new Button("Replace Mziuri");
        Label helloWorld = new Label("Hello World");
        Label helloMziuri = new Label("Hello Mziuri");
        Label byeMziuri = new Label("Bye Mziuri");
        Label byeWorld = new Label("Bye World");

        VBox vBox = new VBox();
        vBox.getChildren().addAll(btn1, btn2, btn3, btn4, btn5);
        btn1.setOnAction(event -> {
            vBox.getChildren().addAll(helloWorld, helloMziuri);
        });
        btn2.setOnAction(event -> {
            vBox.getChildren().remove(helloWorld);
        });
        btn3.setOnAction(event -> {
            vBox.getChildren().remove(helloMziuri);
        });
        btn4.setOnAction(event -> {
            vBox.getChildren().remove(helloWorld);
            if (!vBox.getChildren().contains(byeWorld)) {
                vBox.getChildren().add(byeWorld);
            }
        });
        btn5.setOnAction(event -> {
            vBox.getChildren().remove(helloMziuri);
            if (!vBox.getChildren().contains(byeMziuri)) {
                vBox.getChildren().add(byeMziuri);
            }
        });
        Scene scene = new Scene(vBox, 320, 240);
        stage.show();
        stage.setTitle("Hello!");
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}