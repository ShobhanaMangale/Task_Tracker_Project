package com.example;

import java.util.ArrayList;
import java.util.List;

public class TaskUpdate {

    private List<String> tasks = new ArrayList<>();

    // Add task
    public void addTask(String task) {
        tasks.add(task);
    }

    // Update task
    public boolean updateTask(int index, String newTask) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, newTask);
            return true;
        }
        return false;
    }

    // Get tasks
    public List<String> getTasks() {
        return tasks;
    }
}
