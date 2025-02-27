package com.example.goalsApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompletedGoalsController {
    private CompletedGoalsView completedGoalsView;
    private DatabaseManager databaseManager;
    private ObservableList<String> completedGoalsList;

    public CompletedGoalsController() {
        this.databaseManager = new DatabaseManager();
        this.completedGoalsView = new CompletedGoalsView();
        this.completedGoalsList = FXCollections.observableArrayList();
        loadCompletedGoals();
        completedGoalsView.getCompletedGoalsListView().setItems(completedGoalsList);
        completedGoalsView.getCloseButton().setOnAction(e -> completedGoalsView.getStage().close());
        completedGoalsView.getStage().show();
    }

    private void loadCompletedGoals() {
        try (Connection conn = databaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT title, tag FROM goals WHERE isCompleted = 1");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String title = rs.getString("title");
                String tag = rs.getString("tag");
                completedGoalsList.add(title + " (" + tag + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}