package com.example.goalsApp;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        GoalsView goalsView = new GoalsView(primaryStage);
        new GoalsController(goalsView);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
