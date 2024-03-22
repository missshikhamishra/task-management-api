package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Task;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.payload.request.*;
import com.bezkoder.springjwt.payload.response.GetAllTaskResponse;
import com.bezkoder.springjwt.repository.TaskRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.security.jwt.AuthTokenFilter;
import com.bezkoder.springjwt.security.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class MainController {

  @Autowired
  private TaskService taskService;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private AuthTokenFilter authTokenFilter;

  @Autowired
  private TaskRepository taskRepository;

  @PostMapping("/addTask")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity addTask(@RequestBody AddTaskRequest addTaskRequest){

      Optional<User> optionalUser = userRepository.findByUsername(addTaskRequest.getUsername());
      if(optionalUser.isEmpty()){
          return new ResponseEntity("User does not exist with provided username." , HttpStatus.BAD_REQUEST);
      }

      String result  = taskService.addTask(addTaskRequest);

     return new ResponseEntity(result , HttpStatus.OK);
  }

  @GetMapping("/getAllTaskOfUser")
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
  public ResponseEntity getAllTaskOdUser(@RequestBody GetAllTaskRequest getAllTaskRequest){

      Optional<User> optionalUser = userRepository.findByUsername(getAllTaskRequest.getUsername());
      if(optionalUser.isEmpty()){
          return new ResponseEntity("User does not exist with provided username." , HttpStatus.BAD_REQUEST);
      }

      GetAllTaskResponse response  = taskService.getTask(getAllTaskRequest);

      return new ResponseEntity(response , HttpStatus.OK);
  }

  @PutMapping("/updateTaskDetails")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity updateTaskDetails(@RequestBody TaskUpdateDetail taskUpdateDetail){

      Optional<Task> optionalTask  = taskRepository.findById(taskUpdateDetail.getTaskTitle());
      if(optionalTask.isEmpty()){
          return new ResponseEntity("Task is not present with the given title !!" , HttpStatus.BAD_REQUEST);
      }

      String result  = taskService.updateTaskDetail(taskUpdateDetail);

      return new ResponseEntity(result , HttpStatus.OK);

  }

  @PutMapping("/updateStatus")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity updateStatus(@RequestBody UpdateStatus updateStatus){

      Optional<Task> optionalTask  = taskRepository.findById(updateStatus.getTitle());
      if(optionalTask.isEmpty()){
          return new ResponseEntity("Task is not present with the given title !!" , HttpStatus.BAD_REQUEST);
      }

      String result  = taskService.updateStatus(updateStatus);

      return new ResponseEntity(result , HttpStatus.OK);

  }

  @DeleteMapping("/deleteTask")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity deleteTask(@RequestBody DeleteTask deleteTask){

      Optional<Task> optionalTask  = taskRepository.findById(deleteTask.getTitle());
      if(optionalTask.isEmpty()){
          return new ResponseEntity("Task is not present with the given title !!" , HttpStatus.BAD_REQUEST);
      }

      String result  = taskService.deleteTask(deleteTask);

      return new ResponseEntity(result , HttpStatus.OK);
  }


 }
