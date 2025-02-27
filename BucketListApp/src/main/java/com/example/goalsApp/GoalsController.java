package com.example.goalsApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GoalsController {
    private GoalsView goalsView;
    private DatabaseManager databaseManager;
    private ObservableList<String> goalsList;

    public GoalsController(GoalsView goalsView) {
        this.goalsView = goalsView;
        this.databaseManager = new DatabaseManager();
        this.goalsList = FXCollections.observableArrayList();
        this.goalsView.getGoalsListView().setItems(goalsList);
        loadGoals();

        goalsView.getAddButton().setOnAction(e -> addGoal());
        goalsView.getViewCompletedGoalsButton().setOnAction(e -> openCompletedGoalsView());
        goalsView.getMarkAsCompletedButton().setOnAction(e -> markGoalAsCompleted());
    }

    private void loadGoals() {
        try (Connection conn = databaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT title FROM goals WHERE isCompleted = 0");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                goalsList.add(rs.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addGoal() {
        String title = goalsView.getGoalField().getText();
        String tag = goalsView.getTagComboBox().getValue();
        if (!title.isEmpty() && tag != null) {
            try (Connection conn = databaseManager.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("INSERT INTO goals (title, tag) VALUES (?, ?)")) {
                stmt.setString(1, title);
                stmt.setString(2, tag);
                stmt.executeUpdate();
                goalsList.add(title);
                goalsView.getGoalField().clear();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void openCompletedGoalsView() {
        new CompletedGoalsController();
    }

    private void markGoalAsCompleted() {
        String selectedGoal = goalsView.getGoalsListView().getSelectionModel().getSelectedItem();
        if (selectedGoal != null) {
            try (Connection conn = databaseManager.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("UPDATE goals SET isCompleted = 1 WHERE title = ?")) {
                stmt.setString(1, selectedGoal);
                stmt.executeUpdate();
                goalsList.remove(selectedGoal);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}