package com.bezkoder.springjwt.security.services;


import com.bezkoder.springjwt.models.Task;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.payload.request.*;
import com.bezkoder.springjwt.payload.response.GetAllTaskResponse;
import com.bezkoder.springjwt.repository.TaskRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public String addTask(AddTaskRequest addTaskRequest){


        Task task  = new Task();
        task.setTitle(addTaskRequest.getTitle());
        task.setDescription(addTaskRequest.getDescription());
        task.setDueDate(addTaskRequest.getdueDate());
        task.setStatus(addTaskRequest.getStatus());

        //Getting the user from userRepository
        Optional<User> optionalUser  = userRepository.findByUsername(addTaskRequest.getUsername());
        User user  = optionalUser.get();

        task.setUser(optionalUser.get());

        //Getting the list of all task of given user and add onr more task.
        List<Task> taskList  = user.getTaskList();
        taskList.add(task);

        //save the task into the task repository.
        task  = taskRepository.save(task);

        return "Task has been added into the Db.";
    }

    public GetAllTaskResponse getTask(GetAllTaskRequest getAllTaskRequest){

        Optional<User> optionalUser  = userRepository.findByUsername(getAllTaskRequest.getUsername());
        User user  = optionalUser.get();

        //Getting the TaskList of user
        List<Task> taskList  = user.getTaskList();

        //creating the list of response which will be containing title of all tasks.
        List<String> ans  = new ArrayList<>();
        for(Task task : taskList){
            ans.add(task.getTitle());
        }

        //Creating the Response
        GetAllTaskResponse response  = new GetAllTaskResponse();
        response.setTaskList(ans);


        return response;

    }

    public String updateTaskDetail(TaskUpdateDetail taskUpdateDetail){

        //Getting the task from task repository
        Task task  = taskRepository.findById(taskUpdateDetail.getTaskTitle()).get();

        //doing some update on task.
        task.setDescription(taskUpdateDetail.getDetail());
        taskRepository.save(task);

        return "Task has been updated.";
    }

    public String deleteTask(DeleteTask deleteTask){

        Task task  = taskRepository.findById(deleteTask.getTitle()).get();

        //Delete the task detail.
        taskRepository.delete(task);

        return "Task has been deleted.";
    }


    public String updateStatus(UpdateStatus updateStatus){

        Task task  = taskRepository.findById(updateStatus.getTitle()).get();

        //Update the status of task.
        task.setStatus(updateStatus.getStatus());

        taskRepository.save(task);

        return "Task has been updated.";

    }

}
