package ge.mziuri.demo;

import ge.mziuri.demo.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PersonApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        TextField firstNameField = new TextField();
        firstNameField.setPromptText("First Name");
        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Last Name");

        ComboBox<Integer> dayBox = new ComboBox<>();
        dayBox.getItems().addAll(
                IntStream.rangeClosed(1, 31).boxed().toList()
        );
        ComboBox<Integer> yearBox = new ComboBox<>();
        yearBox.getItems().addAll(
                IntStream.rangeClosed(1970, 2026).boxed().toList()
        );
        dayBox.setPromptText("Day");
        yearBox.setPromptText("Day");
        ComboBox<String> monthBox = new ComboBox<>();
        monthBox.getItems().addAll(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        );
        monthBox.setPromptText("Month");
        ComboBox<String> genderBox = new ComboBox<>();
        genderBox.getItems().addAll("Male", "Female");
        genderBox.setPromptText("Gender");

        ObservableList<Person> persons = FXCollections.observableArrayList();
        ListView<Person> listView = new ListView<>(persons);

        Button button = new Button("Add Person");
        button.setOnAction(event -> {
            try {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                int birthYear = yearBox.getValue();
                int day = dayBox.getValue();
                String month = monthBox.getValue();
                String gender = genderBox.getValue();
                Person person = new Person(day, month, birthYear, firstName, gender, lastName);
                persons.add(person);
                firstNameField.clear();
                lastNameField.clear();
                yearBox.setValue(null);
                dayBox.setValue(null);
                monthBox.setValue(null);
                genderBox.setValue(null);

            } catch (Exception e) {
                System.out.println("Incorrect Data");
            }
        });

        VBox layout = new VBox(10, firstNameField, lastNameField,dayBox, monthBox, yearBox, genderBox, button, listView);
        Scene scene = new Scene(layout, 400, 500);
        stage.show();
        stage.setTitle("Person List");
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