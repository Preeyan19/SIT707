package com.ontrack.service;

import java.util.*;

public class OnTrackService {
    private Map<String, List<String>> studentTasks = new HashMap<>();
    private Map<String, String> taskDetails = new HashMap<>();
    private Map<String, List<String>> taskMessages = new HashMap<>();

    public List<String> taskInbox(String studentId) {
        return studentTasks.getOrDefault(studentId, new ArrayList<>());
    }

    public String viewTask(String taskId) {
        return taskDetails.getOrDefault(taskId, "Task not found");
    }

    public boolean sendMessage(String taskId, String sender, String message) {
        if (!taskDetails.containsKey(taskId) || message == null || message.isEmpty()) return false;
        taskMessages.putIfAbsent(taskId, new ArrayList<>());
        taskMessages.get(taskId).add(sender + ": " + message);
        return true;
    }

    public String submitTask(String studentId, String taskTitle) {
        if (studentId == null || studentId.isEmpty() || taskTitle == null || taskTitle.isEmpty())
            return null;
        String taskId = UUID.randomUUID().toString();
        taskDetails.put(taskId, taskTitle);
        studentTasks.putIfAbsent(studentId, new ArrayList<>());
        studentTasks.get(studentId).add(taskId);
        return taskId;
    }
}
