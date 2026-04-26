import java.util.*;

// Priority enum (BEST PRACTICE)
enum Priority {
    HIGH, MEDIUM, LOW
}

// Task class
class Task {
    private String title;
    private Priority priority;
    private boolean completed;

    public Task(String title, Priority priority) {
        this.title = title;
        this.priority = priority;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public Priority getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }
}

// Main App
public class TaskViewAndPriorityApp {

    private List<Task> tasks = new ArrayList<>();

    // Add task
    public void addTask(String title, Priority priority) {
        tasks.add(new Task(title, priority));
    }

    // Complete task
    public boolean completeTask(String title) {
        for (Task t : tasks) {
            if (t.getTitle().equalsIgnoreCase(title)) {
                t.markCompleted();
                return true;
            }
        }
        return false;
    }

    // View tasks by priority
    public List<Task> getTasksByPriority() {
        List<Task> sorted = new ArrayList<>(tasks);

        Collections.sort(sorted, Comparator.comparing(Task::getPriority));

        return sorted;
    }

    // View pending tasks
    public List<Task> getPendingTasks() {
        List<Task> pending = new ArrayList<>();

        for (Task t : tasks) {
            if (!t.isCompleted()) {
                pending.add(t);
            }
        }
        return pending;
    }

    // Get all tasks (for testing)
    public List<Task> getAllTasks() {
        return tasks;
    }
}