package com.masai.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User{
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private int id;
private String username;
private String password;
private String role;

@	JsonIgnore
@OneToMany(mappedBy="user")
private List<Task> tasks;

public User() {
	super();
	// TODO Auto-generated constructor stub
}

public User(String username, String password, String role) {
	super();
	this.username = username;
	this.password = password;
	this.role = role;
}

public int getId() {
	return id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public List<Task> getTasks() {
	return tasks;
}

public void setTasks(List<Task> tasks) {
	this.tasks = tasks;
}


}
