package com.example.goalsApp;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GoalsView {
    private Stage stage;
    private TextField goalField;
    private ComboBox<String> tagComboBox;
    private Button addButton;
    private Button viewCompletedGoalsButton;
    private ListView<String> goalsListView;
    private Button markAsCompletedButton;

    public GoalsView(Stage stage) {
        this.stage = stage;
        initialize();
    }

    private void initialize() {
        VBox layout = new VBox(10);
        goalField = new TextField();
        goalField.setPromptText("Введите вашу цель");

        tagComboBox = new ComboBox<>();
        tagComboBox.getItems().addAll("Работа", "Отношения", "Личностный рост", "Здоровье", "Финансы");
        tagComboBox.setPromptText("Выберите тег");

        markAsCompletedButton = new Button("Отметить как выполненную");
        addButton = new Button("Добавить цель");
        viewCompletedGoalsButton = new Button("Просмотреть выполненные цели");

        goalsListView = new ListView<>();

        layout.getChildren().addAll(goalField, tagComboBox, addButton, goalsListView, viewCompletedGoalsButton, markAsCompletedButton);
        Scene scene = new Scene(layout, 600, 600);
        stage.setTitle("Планы и цели");
        stage.setScene(scene);

        layout.setStyle(
        "-fx-background-color:rgb(179, 180, 196); " +
        "-fx-text-fill: white; " +
        "-fx-font-size: 14px; " +
        "-fx-padding: 10px 20px; " +
        "-fx-border-radius: 5px; " +
        "-fx-background-radius: 5px;" +
        "-fx-font-family: 'Century Gothic';"
    );

    }

    // Add getters for the new components
    public ComboBox<String> getTagComboBox() {
        return tagComboBox;
    }

    public TextField getGoalField() {
        return goalField;
    }

    public Button getAddButton() {
        return addButton;
    }

    public Button getViewCompletedGoalsButton() {
        return viewCompletedGoalsButton;
    }

    public ListView<String> getGoalsListView() {
        return goalsListView;
    }

    public Button getMarkAsCompletedButton() {
        return markAsCompletedButton;
    }
}