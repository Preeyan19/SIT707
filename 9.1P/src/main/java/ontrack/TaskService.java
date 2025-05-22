package ontrack;

import java.util.*;

public class TaskService {
    private static final Map<String, List<String>> studentTasks = new HashMap<>();

    static {
        studentTasks.put("S123", Arrays.asList("Task 1", "Task 2"));
        studentTasks.put("S456", Arrays.asList("Task A", "Task B", "Task C"));
    }

    public List<String> taskInbox(String studentId) {
        return studentTasks.getOrDefault(studentId, new ArrayList<>());
    }
}
