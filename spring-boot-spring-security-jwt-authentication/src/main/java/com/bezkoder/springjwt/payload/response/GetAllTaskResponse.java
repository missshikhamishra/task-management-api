package com.bezkoder.springjwt.payload.response;

import java.util.List;

public class GetAllTaskResponse {
    private List<String> taskList;

    public List<String> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<String> taskList) {
        this.taskList = taskList;
    }
}
