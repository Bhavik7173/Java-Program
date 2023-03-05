package com.gl.week1.day3;

import java.util.Scanner;

public class TaskDAO {
	// String array to store all the tasks
	Task tasks[];
	// represent total number of task are in tasks
	int cnt = 0;
	Scanner scanner;

	// initialize the tasks array
	public TaskDAO(int numOfTask) {
		tasks = new Task[numOfTask];
		scanner = new Scanner(System.in);
	}

	// insert new task in array of tasks
	public int insertTask(Task task) {
		if (isFull()) {
			return -1;
		} else {
			tasks[cnt] = task;
			cnt++;
			return 1;
		}
	}

	// delete the task from array of task
	public int deleteTask(String taskTitle) {
		if (isEmpty()) {
			return -1;
		} else {
			int index = searchTask(taskTitle);
			if (index == -1) {
				return -1;
			} else {
				for (int i = index; i < cnt - 1; i++) {
					tasks[i] = tasks[i + 1];
				}
				tasks[cnt] = null;
				cnt--;
				return 1;
			}
		}
	}

	// update task
	public int updateTask(Task task) {
		if (isEmpty()) {
			return -1;
		} else {
			int index = -1;
			
			index = searchTask(task.getTaskTitle());
			if (index != -1) {
				tasks[index].setTaskText(task.getTaskText());
				tasks[index].setAssignedTo(task.getAssignedTo());
			} 
			return index;
		}
	}

	// search the task and remove index of that

	public int searchTask(String taskTitle) {
		int index = -1;
		if (isEmpty()) {
			return -1;
		} else {
			for (int i = 0; i < cnt; i++) {
				if (tasks[i].getTaskTitle().equals(taskTitle)) {
					index = i;
					break;
				}
			}
		}
		return index;
	}
	void assignTask(int number,String user)
	{
		tasks[number-1].setAssignedTo(user);
	}
	public Task[] getAllTasks() {
		return tasks;
	}
	public boolean isEmpty()
	{
		if(cnt==0)
			return true;
		else 
			return false;
	}
	public boolean isFull()
	{
		if(cnt==tasks.length)
			return true;
		return false;
	}
}
