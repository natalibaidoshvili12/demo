package ge.mziuri.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ListViewApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        TextField textField = new TextField();
        textField.setPromptText("Enter a task here: ");
        Button addButton = new Button("Add Task");
        Button removeButton = new Button("Remove Task");
        Button markDoneButton = new Button("Mark Done");
        Button clearAllButton = new Button("Clear All");
        ListView<String> taskList = new ListView<>();
        addButton.setOnAction(e -> {
            String task = textField.getText();
            if (!task.isEmpty()) {
                taskList.getItems().add(task);
                textField.clear();
            } else {
                showError("Task cannot be empty");
            }
        });
        removeButton.setOnAction(e -> {
            int selectedIndex = taskList.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                taskList.getItems().remove(selectedIndex);
            } else {
                showError("Task is not marked");
            }
        });
        markDoneButton.setOnAction(e -> {
            int selectedIndex = taskList.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                String task = taskList.getItems().get(selectedIndex);
                if (!task.startsWith("[DONE]")) {
                    taskList.getItems().set(selectedIndex, "[DONE] " + task);
                }
            } else {
                showError("Task is already done");
            }
        });
        clearAllButton.setOnAction(e -> {
            taskList.getItems().clear();
        });
        HBox hbox = new HBox(addButton, removeButton, markDoneButton, clearAllButton);
        VBox layout = new VBox(10, textField, taskList, hbox);
        Scene scene = new Scene(layout, 320, 240);
        stage.show();
        stage.setTitle("Task Manager");
        stage.setScene(scene);
    }

    private void showError(String taskCannotBeEmpty) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);alert.setContentText(taskCannotBeEmpty);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}