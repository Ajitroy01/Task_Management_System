package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	private String description;
	private String priority;
	private LocalDate dueDate;
	private boolean completed;
	
	@OneToMany(mappedBy = "parentTask", cascade= CascadeType.ALL)
  private List<Subtask> substaks = new ArrayList<>();

	@ManyToOne
	private User user;
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(String title,String priority, LocalDate dueDate) {
		super();
		this.title = title;
		this.priority = priority;
		this.dueDate = dueDate;
	}

	public int getId() {
		return id;
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

	public void setDesc(String desc) {
		this.description = desc;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public List<Subtask> getSubstaks() {
		return substaks;
	}

	public void setSubstaks(List<Subtask> substaks) {
		this.substaks = substaks;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
