package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class AppTest {
    @Test
    void testAddTask() {
        TodoList list = new TodoList();
        list.add("Buy milk");

        List<String> allTasks = list.getAllTasks();
        assertTrue(allTasks.contains("Buy milk"));
    }

    @Test
    void testCompleteTask() {
        TodoList list = new TodoList();
        list.add("Buy eggs");
        list.complete("Buy eggs");

        List<String> completedTasks = list.getCompletedTasks();
        assertTrue(completedTasks.contains("Buy eggs"));
    }

    @Test
    void testClearTasks() {
        TodoList list = new TodoList();
        list.add("Task 1");
        list.add("Task 2");
        list.clear();

        List<String> allTasks = list.getAllTasks();
        assertTrue(allTasks.isEmpty());
    }

    @Test
    void testIncompleteTasks() {
        TodoList list = new TodoList();
        list.add("Task A");
        list.add("Task B");
        list.complete("Task A");

        List<String> incompleteTasks = list.getIncompleteTasks();
        assertTrue(incompleteTasks.contains("Task B"));
        assertFalse(incompleteTasks.contains("Task A"));
    }
}
