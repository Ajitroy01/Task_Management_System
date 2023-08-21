package com.masai.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Task;


@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

	List<Task> findByPriorityIgnoreCase(String priority);
	List<Task> findByDueDate(LocalDate dueDate);
	List<Task> findByCompleted(boolean completed);
	
}
