package com.example.goalsApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:goals.db";

    public DatabaseManager() {
        createTables();
    }

    private void createTables() {
        String createGoalsTable = "CREATE TABLE IF NOT EXISTS goals (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT NOT NULL," +
                "tag TEXT NOT NULL," +
                "isCompleted BOOLEAN NOT NULL DEFAULT 0);";

        String createUsersTable = "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT NOT NULL UNIQUE);";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(createGoalsTable);
            stmt.execute(createUsersTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
