package com.gl.week1.day4dao;

import com.gl.week1.day4.model.Task;

public interface TaskDAO {
	int insertTask(Task task);
	int deleteTask(String taskTitle,String clientName);
	int updateTask(Task task);
	int searchTask(String taskTitle,String clientName);	
	Task[] getAllTaskByUser(String clientName);
	boolean assignTaskToVisitor(Task task,String visitor);
	boolean isFull();
	boolean isEmpty();
}