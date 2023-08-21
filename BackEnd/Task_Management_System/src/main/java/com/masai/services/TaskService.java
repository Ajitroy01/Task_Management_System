package com.masai.services;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.TaskException;
import com.masai.model.Task;
import com.masai.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepo;
	
	public Task createTask(Task task) {
		validateTask(task);
		return taskRepo.save(task);
	}
	
	public List<Task> getAllTasks(){
		return taskRepo.findAll();
	}
	
	public Task updateTask(int taskId, Task task) {
		Task exist = taskRepo.findById(taskId).orElseThrow(() -> new TaskException("Task not found."));
		validateTask(task);
		
		exist.setTitle(task.getTitle());
		exist.setDesc(task.getDescription());
		exist.setPriority(task.getPriority());
		exist.setDueDate(task.getDueDate());
		
		return taskRepo.save(exist);
	}
	
	public void markTaskAsCompleted(int taskId) {
		Task exist = taskRepo.findById(taskId).orElseThrow(() -> new TaskException("Task not found."));
		
		exist.setCompleted(true);
		
		taskRepo.save(exist);
	}
	
	public List<Task> filterByPriority(String priority){
		return taskRepo.findByPriorityIgnoreCase(priority);
	}
	
	public List<Task> filterByDueDate(LocalDate dueDate){
		return taskRepo.findByDueDate(dueDate);
	}
	
	public List<Task> filterByTaskCompleted(boolean completed){
		return taskRepo.findByCompleted(completed);
	}
	
	public List<Task> sortByPriority(){
		return taskRepo.findAll().stream().sorted(Comparator.comparing(Task::getPriority)).collect(Collectors.toList());
	}
	public List<Task> sortByDueDate(){
		return taskRepo.findAll().stream().sorted(Comparator.comparing(Task::getDueDate)).collect(Collectors.toList());
	}
	
	public void validateTask(Task task) {
		if(task.getTitle() == null || task.getTitle().isEmpty()) {
			throw new TaskException("Task title cannot be ignored");
		}
		if(task.getPriority() == null || !Arrays.asList("high", "medium", "low").contains(task.getPriority())) {
			throw new TaskException("Invalid Priority Value");
		}
	}
}
