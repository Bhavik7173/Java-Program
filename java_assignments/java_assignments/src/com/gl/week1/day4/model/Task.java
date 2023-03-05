package com.gl.week1.day4.model;

public class Task {
	private static int totalTask = 0;
	private int taskId; // task number auto generated
	private String taskTitle;
	private String taskText;
	private String assignedTo;
	private String clientName;
	
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

	public static int getTotalTask() {
		return totalTask;
	}

	public static void setTotalTask(int totalTask) {
		Task.totalTask = totalTask;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskTitle=" + taskTitle + ", taskText=" + taskText + ", assignedTo="
				+ assignedTo + ", clientName=" + clientName + "]";
	}

	public Task(String taskTitle, String taskText,String clientName) {
		super();
		this.taskTitle = taskTitle;
		this.taskText = taskText;		
		this.clientName = clientName;		
		totalTask++;
		this.taskId = totalTask;
	}
}
