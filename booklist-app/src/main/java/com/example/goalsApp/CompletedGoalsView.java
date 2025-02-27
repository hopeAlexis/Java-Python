package com.example.goalsApp;

import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CompletedGoalsView {
    private Stage stage;
    private ListView<String> completedGoalsListView;
    private Button closeButton;

    public CompletedGoalsView() {
        stage = new Stage();
        initialize();
    }

    private void initialize() {
        VBox layout = new VBox(10);
        completedGoalsListView = new ListView<>();
        closeButton = new Button("Закрыть");

        layout.setStyle(
            "-fx-background-color:rgb(179, 180, 196); " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 14px; " +
            "-fx-padding: 10px 20px; " +
            "-fx-border-radius: 5px; " +
            "-fx-background-radius: 5px;" +
            "-fx-font-family: 'Century Gothic';"
        );

        completedGoalsListView.setCellFactory(param -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setStyle(""); // Reset style if the cell is empty
                } else {
                    setText(item);
                    // Customize appearance based on the tag
                    if (item.contains("(Работа)")) {
                        setStyle("-fx-text-fill: blue;");
                    } else if (item.contains("(Отношения)")) {
                        setStyle("-fx-text-fill: red;");
                    } else if (item.contains("(Личностный рост)")) {
                        setStyle("-fx-text-fill: purple;");
                    } else if (item.contains("(Здоровье)")) {
                        setStyle("-fx-text-fill: green;");
                    } else if (item.contains("(Финансы)")) {
                        setStyle("-fx-text-fill: orange;");
                    } else {
                        setStyle(""); // Reset style for other cases
                    }
                }
            }
        });

        layout.getChildren().addAll(completedGoalsListView, closeButton);
        Scene scene = new Scene(layout, 400, 400);
        stage.setTitle("Завершенные цели");
        stage.setScene(scene);
    }

    public ListView<String> getCompletedGoalsListView() {
        return completedGoalsListView;
    }

    public Button getCloseButton() {
        return closeButton;
    }

    public Stage getStage() {
        return stage;
    }
}

