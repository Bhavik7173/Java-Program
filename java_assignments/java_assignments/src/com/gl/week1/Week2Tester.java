package com.gl.week1;

/*
Problem Statement : 
1. As a user I should be able to add the task into an array
2. As a user I should be able to update the task in the array
3. As a user I should be able to delete the task in the array
4. As a user I should be able to search a task from an array 
*/

import java.util.Scanner;

public class Week2Tester {

	String[] tasks = new String[10];
	int cnt = 0;
	Scanner scanner = new Scanner(System.in);

	// insert new task in array of tasks
	public boolean insertTask(String task) {
		if (isFull())// by default true
		{
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
	public int updateTask(String oldTask, String newTask) {
		if (isEmpty()) {
			return -1;
		} else {

			int index = searchTask(oldTask);
			if (index != -1) {
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

	public void disp() {
		for (int i = 0; i < cnt; i++) {
			System.out.println(tasks[i]);
		}
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

	public static void main(String[] args) {
		Week2Tester tester = new Week2Tester();
		tester.menu();
	}

	void menu() {
		int ch = 0, n;
		String task = "";
		do {
			System.out.println("1. Insert new Task");
			System.out.println("2. Delete a Task");
			System.out.println("3. Update a Task");
			System.out.println("4. Search for a Task");
			System.out.println("5. Display All the Tasks");
			System.out.println("0. Exit");

			System.out.print("Enter your choice : ");
			ch = scanner.nextInt();
			scanner.nextLine(); // to clear the buffer

			// choice + enter => number input stream => enter is stored in this stream
			// so that i will read this line otherwise i have not any option.
			// scanner use to read the line which is use to clear the buffer.
			switch (ch) {
			case 1:
				if (isFull()) // by default true
					System.out.println("Tasks array is overflow!!! you can not insert any more task...");
				else {
					System.out.println("Enter task you want to insert ... ");
					task = scanner.nextLine();

					boolean status = insertTask(task);

					if (status) // by default true
						System.out.println("Task is Successfully inserted...");
					else
						System.out.println("Could not insert a task, try again...");
				}
				break;
			case 2:

				if (isEmpty())
					System.out.println("There are no more Tasks in array...");
				else {
					System.out.println("Enter task you want to remove... ");
					task = scanner.nextLine();

					n = deleteTask(task);

					if (n == 0)
						System.out.println("Task not found!!!");
					else if (n == -1)
						System.out.println("Empty!!!");
					else
						System.out.println("Task is deleted...");
				}
				break;
			case 3:

				if (isEmpty())
					System.out.println("There is no task in array!!!");
				else {
					System.out.println("Enter task you want to udpate... ");
					task = scanner.nextLine();

					if (searchTask(task) == -1)
						System.out.println("not found!!!");
					else {
						System.out.println("Enter new task ... ");
						String newTask = scanner.nextLine();

						n = updateTask(task, newTask);
						if (n == -1)
							System.out.println("Task not found!!!");
						else
							System.out.println("Task updated successfully...");
					}
				}
				break;
			case 4:
				if (isEmpty()) {
					System.out.println("There is no task in array...");
				} else {
					System.out.println("Enter task you want to search... ");
					task = scanner.nextLine();

					n = searchTask(task);
					if (n == -1)
						System.out.println("Task not found");
					else
						System.out.println("Your task is on position : " + (n + 1));
				}
				break;
			case 5:
				if (isEmpty()) {
					System.out.println("There is no task in array...");
				} else {
					disp();
				}
				break;
			case 0:
				System.out.println("Good bye!!!");
				break;
			default:
				System.out.println("please check your input your choice does not exists!!!");
			}
		} while (ch != 0);
	}
}