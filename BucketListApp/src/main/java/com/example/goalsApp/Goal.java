package com.example.goalsApp;

public class Goal {
    private int id;
    private String title;
    private String tag;
    private boolean isCompleted;

    public Goal(int id, String title, String tag, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.tag = tag;
        this.isCompleted = isCompleted;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTag() {
        return tag;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}