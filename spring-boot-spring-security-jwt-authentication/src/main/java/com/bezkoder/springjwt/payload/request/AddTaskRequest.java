package com.bezkoder.springjwt.payload.request;


import com.bezkoder.springjwt.Enums.Status;

import java.time.LocalDate;

public class AddTaskRequest {

    private String title;
    private String description;
    private LocalDate dueDate;
    private Status status;
    private String username;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getdueDate() {
        return dueDate;
    }

    public void setdueDate(LocalDate localDate) {
        this.dueDate = localDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }
}
