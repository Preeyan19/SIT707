package ontrack;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class TaskServiceTest {

    @Test
    public void testTaskInboxForValidStudent() {
        TaskService ts = new TaskService();
        List<String> tasks = ts.taskInbox("S123");
        assertEquals(Arrays.asList("Task 1", "Task 2"), tasks);
    }

    @Test
    public void testTaskInboxForInvalidStudent() {
        TaskService ts = new TaskService();
        List<String> tasks = ts.taskInbox("S999");
        assertTrue(tasks.isEmpty());
    }

    @Test
    public void testTaskInboxForAnotherValidStudent() {
        TaskService ts = new TaskService();
        List<String> tasks = ts.taskInbox("S456");
        assertEquals(Arrays.asList("Task A", "Task B", "Task C"), tasks);
    }

    @Test
    public void testTaskInboxForNullInput() {
        TaskService ts = new TaskService();
        List<String> tasks = ts.taskInbox(null);
        assertTrue(tasks.isEmpty());
    }

    @Test
    public void testTaskInboxForEmptyStringInput() {
        TaskService ts = new TaskService();
        List<String> tasks = ts.taskInbox("");
        assertTrue(tasks.isEmpty());
    }
}
