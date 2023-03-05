package com.gl.week1.day4dao;

import java.util.Scanner;

import com.gl.week1.day4.model.Task;

public class TaskDAOImpl implements TaskDAO {

	Task tasks[];
	int cnt = 0;
	Scanner scanner;

	public TaskDAOImpl() {
		tasks = new Task[10];
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
	public int deleteTask(String taskTitle, String clientName) {
		if (isEmpty()) {
			return -1;
		} else {
			int index = searchTask(taskTitle, clientName);
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

			index = searchTask(task.getTaskTitle(), task.getClientName());
			if (index != -1) {
				tasks[index].setTaskText(task.getTaskText());
				tasks[index].setAssignedTo(task.getAssignedTo());
			}
			return index;
		}
	}

	public int searchTask(String taskTitle, String clientName) {
		int index = -1;
		if (isEmpty()) {
			return -1;
		} else {
			for (int i = 0; i < cnt; i++) {
				if (tasks[i].getTaskTitle().equals(taskTitle) && tasks[i].getClientName().equals(clientName)) {
					index = i;
					break;
				}
			}
		}
		return index;
	}

	public Task[] getAllTaskByUser(String clientName) {
		int taskCnt = 0;
		for (int i = 0; i < cnt; i++) {
			if (clientName.equals(tasks[i].getClientName())) {
				taskCnt++;
			}
		}
		Task[] clientTasks = new Task[taskCnt];
		int index = 0;
		for (int i = 0; i < cnt; i++) {
			if (clientName.equals(tasks[i].getClientName())) {
				clientTasks[index++] = tasks[i];
			}
		}
		return clientTasks;
	}

	public boolean isEmpty() {
		if (cnt == 0)
			return true;
		return false;
	}

	public boolean isFull() {
		if (cnt == tasks.length)
			return true;
		return false;
	}

	@Override
	public boolean assignTaskToVisitor(Task task, String visitor) {
		
		return false;
	}
}