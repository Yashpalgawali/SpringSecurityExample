package com.example.demo.todo;

import java.util.Date;
import java.util.Objects;


public class Todo {

	private long id;
	
	private String username;
	
	private String description;
	
	private Date targetDate;
	
	private boolean done;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date gettargetDate() {
		return targetDate;
	}

	public void settargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isdone() {
		return done;
	}

	public void setdone(boolean done) {
		this.done = done;
	}

	public Todo(long id, String username, String description, Date targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		return id == other.id;
	}

	

}
