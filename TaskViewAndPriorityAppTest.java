import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class TaskViewAndPriorityAppTest {

    @Test
    void testAddTask() {
        TaskViewAndPriorityApp app = new TaskViewAndPriorityApp();

        app.addTask("Study Java", Priority.HIGH);

        assertEquals(1, app.getAllTasks().size());
    }

    @Test
    void testCompleteTask() {
        TaskViewAndPriorityApp app = new TaskViewAndPriorityApp();

        app.addTask("Assignment", Priority.HIGH);

        boolean result = app.completeTask("Assignment");

        assertTrue(result);
        assertTrue(app.getAllTasks().get(0).isCompleted());
    }

    @Test
    void testTaskNotFound() {
        TaskViewAndPriorityApp app = new TaskViewAndPriorityApp();

        app.addTask("Task1", Priority.MEDIUM);

        boolean result = app.completeTask("Wrong Task");

        assertFalse(result);
    }

    @Test
    void testPrioritySorting() {
        TaskViewAndPriorityApp app = new TaskViewAndPriorityApp();

        app.addTask("Low Task", Priority.LOW);
        app.addTask("High Task", Priority.HIGH);
        app.addTask("Medium Task", Priority.MEDIUM);

        List<Task> sorted = app.getTasksByPriority();

        assertEquals("High Task", sorted.get(0).getTitle());
    }

    @Test
    void testPendingTasks() {
        TaskViewAndPriorityApp app = new TaskViewAndPriorityApp();

        app.addTask("Task1", Priority.HIGH);
        app.addTask("Task2", Priority.MEDIUM);

        app.completeTask("Task1");

        List<Task> pending = app.getPendingTasks();

        assertEquals(1, pending.size());
        assertEquals("Task2", pending.get(0).getTitle());
    }

    @Test
    void testStudentRoutineScenario() {
        TaskViewAndPriorityApp app = new TaskViewAndPriorityApp();

        app.addTask("Study ML", Priority.HIGH);
        app.addTask("Drink Water", Priority.MEDIUM);
        app.addTask("Scroll Instagram", Priority.LOW);

        app.completeTask("Drink Water");

        assertEquals(2, app.getPendingTasks().size());
    }

    @Test
    void testAllTasksCompleted() {
        TaskViewAndPriorityApp app = new TaskViewAndPriorityApp();

        app.addTask("Task1", Priority.HIGH);
        app.addTask("Task2", Priority.LOW);

        app.completeTask("Task1");
        app.completeTask("Task2");

        assertEquals(0, app.getPendingTasks().size());
    }

    @Test
    void testCaseInsensitiveCompletion() {
        TaskViewAndPriorityApp app = new TaskViewAndPriorityApp();

        app.addTask("Study", Priority.HIGH);

        boolean result = app.completeTask("study");

        assertTrue(result);
    }

    @Test
    void testEmptyTaskList() {
        TaskViewAndPriorityApp app = new TaskViewAndPriorityApp();

        assertEquals(0, app.getPendingTasks().size());
    }
}