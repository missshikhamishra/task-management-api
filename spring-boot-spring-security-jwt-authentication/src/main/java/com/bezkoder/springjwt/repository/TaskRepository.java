package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task , String> {
}
