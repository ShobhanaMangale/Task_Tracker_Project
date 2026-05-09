package com.example;

import java.util.ArrayList;
import java.util.List;

public class TaskUpdate {

    // List to store tasks
    private List<String> tasks;

    // Constructor
    public TaskUpdate() {
        tasks = new ArrayList<>();
    }

    // Method to add task
    public void addTask(String task) {
        tasks.add(task);
    }

    // Method to update task
    public boolean updateTask(int index, String newTask) {

        // Check valid index
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, newTask);
            return true;
        }

        return false;
    }

    // Method to get tasks
    public List<String> getTasks() {
        return tasks;
    }
}
