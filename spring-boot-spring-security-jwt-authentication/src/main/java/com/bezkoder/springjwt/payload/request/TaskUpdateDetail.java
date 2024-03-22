package com.bezkoder.springjwt.payload.request;

public class TaskUpdateDetail {

    private String detail;
    private String taskTitle;
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }
}
