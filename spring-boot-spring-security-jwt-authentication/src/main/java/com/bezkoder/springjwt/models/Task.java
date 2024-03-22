package com.bezkoder.springjwt.models;


import com.bezkoder.springjwt.Enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tasks",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "title"),
        })
public class Task {

    @Id
    private String title;

    @NotBlank
    @Size(max = 250)
    private String description;

    @NotBlank
    private LocalDate dueDate;


    @Enumerated(value = EnumType.STRING)
    @NotBlank
    private Status status;


    @JoinColumn
    @ManyToOne
    private User user;

    public Task() {
    }

    public Task(String title, String description, LocalDate dueDate, Status status, User user) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.user = user;
    }

    public Task(String title) {
        this.title = title;
    }

    public Task(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Task(Status status) {
        this.status = status;
    }

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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
