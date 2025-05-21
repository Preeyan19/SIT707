package com.ontrack.model;

public class Task {
    private String id;
    private String studentId;
    private String description;

    public Task(String id, String studentId, String description) {
        this.id = id;
        this.studentId = studentId;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getDescription() {
        return description;
    }
}
