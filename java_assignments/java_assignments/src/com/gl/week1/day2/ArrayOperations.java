package com.gl.week1.day2;


import java.util.Scanner;

public class ArrayOperations {
	// String array to store all the tasks
	String[] tasks;
	// represent total number of task are in tasks
	int cnt = 0;
	Scanner scanner;

	// initialize the tasks array
	public ArrayOperations(int numOfTask) {
		tasks = new String[numOfTask];
		scanner = new Scanner(System.in);
	}

	// insert new task in array of tasks
	public boolean insertTask(String task) {
		if (isFull()) {
			return false;
		} else {
			tasks[cnt] = task;
			cnt++;
			return true;
		}
	}

	// delete the task from array of task
	public int deleteTask(String task) {
		if (isEmpty()) {
			return -1;
		} else {
			int index = searchTask(task);
			if (index == -1) {
				return 0;
			} else {
				for (int i = index; i < cnt - 1; i++) {
					tasks[i] = tasks[i + 1];
				}
				cnt--;
				return 1;
			}
		}
	}

	// update task
	public int updateTask(String oldTask,String newTask) {
		if (isEmpty()) {
			return -1;
		} else {
			
			int index = searchTask(oldTask);
			if(index != -1)
			{
				tasks[index] = newTask;
			}
			return index;
		}
	}

	// search the task and remove index of that
	public int searchTask(String task) {
		int index = -1;
		if (isEmpty()) {
			return -1;
		} else {
			for (int i = 0; i < cnt; i++) {
				if (tasks[i].equals(task)) {
					index = i;
					break;
				}
			}
		}
		return index;
	}
	public void disp()
	{
		for(int i=0;i<cnt;i++)
		{
			System.out.println(tasks[i]);
		}
	}
	public boolean isEmpty()
	{
		if(cnt==0)
			return true;
		return false;
	}
	public boolean isFull()
	{
		if(cnt==tasks.length)
			return true;
		return false;
	}
}
