package org.example;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        TodoList list = new TodoList();

        list.add("Buy milk");
        list.add("Buy eggs");
        list.add("Prepare a lesson for CSC 122");
        list.add("Sow beet seeds");

        list.complete("Buy eggs");

        System.out.println("All tasks:");
        list.all();
        
        System.out.println("Completed tasks:");
        list.completed();
        
        System.out.println("Incomplete tasks:");
        list.incomplete();

        list.clear();
        System.out.println("After clearing the list:");
        list.all();
    }
}

class TodoList {
    private final Map<String, Boolean> tasks = new LinkedHashMap<>();

    public void add(String task) {
        if (task == null || task.trim().isEmpty()) {
            System.out.println("Task cannot be empty!");
            return;
        }
        if (tasks.containsKey(task)) {
            System.out.println("Task already exists!");
            return;
        }
        tasks.put(task, false);
    }

    public void complete(String task) {
        if (tasks.containsKey(task)) {
            tasks.put(task, true);
        } else {
            System.out.println("Task not found!");
        }
    }

    public void all() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            tasks.forEach((task, completed) -> System.out.println(task + " - " + (completed ? "Completed" : "Incomplete")));
        }
    }

    public void completed() {
        tasks.forEach((task, completed) -> {
            if (completed) {
                System.out.println(task);
            }
        });
    }

    public void incomplete() {
        tasks.forEach((task, completed) -> {
            if (!completed) {
                System.out.println(task);
            }
        });
    }

    public void clear() {
        tasks.clear();
        System.out.println("All tasks cleared.");
    }

    // Getter methods for testing
    public List<String> getAllTasks() {
        return new ArrayList<>(tasks.keySet());
    }

    public List<String> getCompletedTasks() {
        List<String> completed = new ArrayList<>();
        for (Map.Entry<String, Boolean> entry : tasks.entrySet()) {
            if (entry.getValue()) {
                completed.add(entry.getKey());
            }
        }
        return completed;
    }

    public List<String> getIncompleteTasks() {
        List<String> incomplete = new ArrayList<>();
        for (Map.Entry<String, Boolean> entry : tasks.entrySet()) {
            if (!entry.getValue()) {
                incomplete.add(entry.getKey());
            }
        }
        return incomplete;
    }
}
