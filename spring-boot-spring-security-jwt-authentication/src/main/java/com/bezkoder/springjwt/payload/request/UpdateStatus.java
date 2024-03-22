package com.bezkoder.springjwt.payload.request;

import com.bezkoder.springjwt.Enums.Status;

public class UpdateStatus {
    private Status status;
    private String title;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
