package com.masai.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Task;
import com.masai.services.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

	@Autowired
	private TaskService ts;
	
	@GetMapping
	public ResponseEntity<List<Task>> getAllTasks(){
		return new ResponseEntity<List<Task>>(ts.getAllTasks(), HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Task> createTask(@RequestBody @Valid Task task){
		return new ResponseEntity<Task>(ts.createTask(task), HttpStatus.CREATED);
	}
	
	@PutMapping("/{taskId}")
	public ResponseEntity<Task> updateTask(@PathVariable int taskId, @RequestBody @Valid Task task){
		return new ResponseEntity<Task>(ts.updateTask(taskId, task), HttpStatus.OK);
	}
	
	@PutMapping("/{taskId}/complete")
	public ResponseEntity<String> markTaskAsCompleted(@PathVariable int taskId){
		ts.markTaskAsCompleted(taskId);
		return new ResponseEntity<String>("Task marked as completed", HttpStatus.OK);
	}
	
	@GetMapping("/filter-by-priority")
	public ResponseEntity<List<Task>> filterByPriority(@RequestParam String priority){
		return new ResponseEntity<List<Task>>(ts.filterByPriority(priority), HttpStatus.OK);
	}
	@GetMapping("/filter-by-due-date")
	public ResponseEntity<List<Task>> filterByDueDate(@RequestParam LocalDate dueDate){
		return new ResponseEntity<List<Task>>(ts.filterByDueDate(dueDate), HttpStatus.OK);
	}
	
	@GetMapping("/filter-by-completed")
	public ResponseEntity<List<Task>> filterByCompleted(@RequestParam boolean complete){
		return new ResponseEntity<List<Task>>(ts.filterByTaskCompleted(complete), HttpStatus.OK);
	}
	
	@GetMapping("/sort-by-priority")
	public ResponseEntity<List<Task>> SortByPriority(){
		return new ResponseEntity<List<Task>>(ts.sortByPriority(), HttpStatus.OK);
	}
	@GetMapping("/sort-by-due-date")
	public ResponseEntity<List<Task>> SortByDueDate(){
		return new ResponseEntity<List<Task>>(ts.sortByDueDate(), HttpStatus.OK);
	}
}
