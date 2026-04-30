package ge.mziuri.demo;

import ge.mziuri.demo.model.ObjectModel;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ComponentsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox layout = new VBox();
//        ComboBox<String> comboBox = new ComboBox<>();
//        comboBox.getItems().addAll("Audi", "Mercedes", "BMW");
//        comboBox.getItems().addAll("Mitsubishi", "Honda", "Hyundai");
//        comboBox.getItems().addAll("Tesla", "Toyota", "Jeep");
//        comboBox.setVisibleRowCount(4);
//        layout.getChildren().add(comboBox);
//        comboBox.setOnAction(event -> {
//            System.out.println(comboBox.getValue());
//        });

        TableView table = new TableView();
        TableColumn tableColumn1 = new TableColumn("Name");
        tableColumn1.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn tableColumn2 = new TableColumn("Description");
        tableColumn2.setCellValueFactory(new PropertyValueFactory<>("description"));
        TableColumn tableColumn3 = new TableColumn("Price");
        tableColumn3.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn tableColumn4 = new TableColumn("Date");
        tableColumn4.setCellValueFactory(new PropertyValueFactory<>("date"));
        table.getColumns().addAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4);
        ObservableList<ObjectModel> list = FXCollections.observableArrayList();
        list.add(new ObjectModel("Name1", "Description1", "Price1", "Date1"));
        list.add(new ObjectModel("Name2", "Description2", "Price2", "Date2"));
        list.add(new ObjectModel("Name3", "Description3", "Price3", "Date3"));
        list.add(new ObjectModel("Name4", "Description4", "Price4", "Date4"));
        list.add(new ObjectModel("Name5", "Description5", "Price5", "Date5"));
        table.setItems(list);

        layout.getChildren().addAll(table);


        Scene scene = new Scene(layout, 320, 240);
        stage.show();
        stage.setTitle("Components");
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