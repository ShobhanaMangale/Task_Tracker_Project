package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskUpdateTest {

    @Test
    void testUpdateTaskSuccess() {
        TaskUpdate taskUpdate = new TaskUpdate();

        taskUpdate.addTask("Task 1");
        taskUpdate.addTask("Task 2");

        boolean result = taskUpdate.updateTask(1, "Updated Task 2");

        assertTrue(result);
        assertEquals("Updated Task 2", taskUpdate.getTasks().get(1));
    }

    @Test
    void testUpdateTaskInvalidIndex() {
        TaskUpdate taskUpdate = new TaskUpdate();

        taskUpdate.addTask("Task 1");

        boolean result = taskUpdate.updateTask(5, "Invalid");

        assertFalse(result);
    }
}
