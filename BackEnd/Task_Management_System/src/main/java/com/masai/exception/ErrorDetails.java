package com.masai.exception;

import java.time.LocalDateTime;

public class ErrorDetails {

	private LocalDateTime timestamp = LocalDateTime.now();
	private String message;
	private String desc;
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorDetails(LocalDateTime timestamp, String message, String desc) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.desc = desc;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
