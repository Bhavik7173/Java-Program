package com.gl.week1.day3;

public class Task {
	private static int totalTask = 0;
	private int taskId; // task number auto generated
	private String taskTitle;
	private String taskText;
	private String assignedTo;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskText() {
		return taskText;
	}

	public void setTaskText(String taskText) {
		this.taskText = taskText;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskTitle=" + taskTitle + ", taskText=" + taskText + ", assignedTo="
				+ assignedTo + "]";
	}

	public Task(String taskTitle, String taskText) {
		super();
		this.taskTitle = taskTitle;
		this.taskText = taskText;
//		this.assignedTo = assignedTo;
		totalTask++;
		this.taskId = totalTask;
	}
}
