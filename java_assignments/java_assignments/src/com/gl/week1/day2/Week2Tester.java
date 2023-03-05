package com.gl.week1.day2;
/*
Problem Statement : 
1. As a user I should be able to add the task into an array
2. As a user I should be able to update the task in the array
3. As a user I should be able to delete the task in the array
4. As a user I should be able to search a task from an array 
*/

import java.util.Scanner;

public class Week2Tester {
	public static void main(String[] args) {

		int ch = 0, n;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number of tasks you want to store...");
		int size = scanner.nextInt();

		ArrayOperations operations = new ArrayOperations(size);
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
			switch (ch) {
			case 1:
				if (operations.isFull())
					System.out.println("Tasks array is overflow!!! you can not insert any more task...");
				else {
					System.out.println("Enter task you want to insert ... ");
					task = scanner.nextLine();

					boolean status = operations.insertTask(task);

					if (status)
						System.out.println("Task is Successfully inserted...");
					else
						System.out.println("Could not insert a task, try again...");
				}
				break;
			case 2:

				if (operations.isEmpty())
					System.out.println("There are no more Tasks in array...");
				else {
					System.out.println("Enter task you want to remove... ");
					task = scanner.nextLine();

					n = operations.deleteTask(task);

					if (n == 0)
						System.out.println("Task not found!!!");
					else if (n == -1)
						System.out.println("Empty!!!");
					else
						System.out.println("Task is deleted...");
				}
				break;
			case 3:

				if (operations.isEmpty())
					System.out.println("There is no task in array!!!");
				else {
					System.out.println("Enter task you want to udpate... ");
					task = scanner.nextLine();

					if (operations.searchTask(task) == -1)
						System.out.println("not found!!!");
					else {
						System.out.println("Enter new task ... ");
						String newTask = scanner.nextLine();

						n = operations.updateTask(task, newTask);
						if (n == -1)
							System.out.println("Task not found!!!");
						else
							System.out.println("Task updated successfully...");
					}
				}
				break;
			case 4:
				if (operations.isEmpty()) {
					System.out.println("There is no task in array...");
				} else {
					System.out.println("Enter task you want to search... ");
					task = scanner.nextLine();

					n = operations.searchTask(task);
					if (n == -1)
						System.out.println("Task not found");
					else
						System.out.println("Your task is on position : " + (n + 1));
				}
				break;
			case 5:
				if (operations.isEmpty()) {
					System.out.println("There is no task in array...");
				} else {
					operations.disp();
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