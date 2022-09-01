package edu.eci.taskmicro.entities;

public class Task {
    private String name, description, assignedTo, dueDate, createdAt;
    private Status status;

    public Task(String name, String description, String assignedTo, String dueDate, String createdAt,
            Status status) {
        this.name = name;
        this.description = description;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.createdAt = createdAt;
        this.status = status;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignedTo() {
        return this.assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
