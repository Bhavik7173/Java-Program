package com.gl.week1.day3;

import java.util.Scanner;

public class Week3Tester {
	public static Task readTask() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter new task Title ... ");
		String taskTitle = scanner.nextLine();

		System.out.println("Enter new task description... ");
		String taskText = scanner.nextLine();

		
		Task task = new Task(taskTitle, taskText);
		
		return task;
	}

	public static void main(String[] args) {

		int ch = 0, n;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of tasks you want to store...");
		int size = scanner.nextInt();
		TaskDAO taskDAO = new TaskDAO(size);
		do {
			System.out.println("1. Insert new Task");
			System.out.println("2. Delete a Task");
			System.out.println("3. Update a Task");
			System.out.println("4. Search for a Task");
			System.out.println("5. Assign Task to user");			
			System.out.println("6. Display All the Tasks");
			System.out.println("0. Exit");

			System.out.print("Enter your choice : ");
			ch = scanner.nextInt();

			switch (ch) {
			case 1:
				if (taskDAO.isFull())
					System.out.println("Tasks array is overflow!!! you can not insert any more task...");
				else {
					n = taskDAO.insertTask(readTask());

					if (n == 1)
						System.out.println("Task is Successfully inserted...");
					else
						System.out.println("Could not insert a task, try again...");
				}
				break;
			case 2:
				if (taskDAO.isEmpty())
					System.out.println("There are no more Tasks in array...");
				else {
					System.out.println("Enter task title you want to delete ... ");
					scanner.nextLine();
					String taskTitle = scanner.nextLine();

					n = taskDAO.deleteTask(taskTitle);
					if (n == 0)
						System.out.println("Task not found!!!");
					else
						System.out.println("Task is deleted...");

				}
				break;
			case 3:
				if (taskDAO.isEmpty())
					System.out.println("There is no task in array!!!");
				else {
					n = taskDAO.updateTask(readTask());
					if (n == -1)
						System.out.println("Task not found!!!");
					else
						System.out.println("Task updated successfully...");
				}
				break;
			case 4:
				if (taskDAO.isEmpty()) {
					System.out.println("There is no task in array...");
				} else {
					System.out.println("Enter task title you want to search... ");
					scanner.nextLine();
					String taskTitle = scanner.nextLine();

					n = taskDAO.searchTask(taskTitle);
					if (n == -1)
						System.out.println("Task not found");
					else
						System.out.println("Your task is on position : " + (n + 1));

				}
				break;
			case 5:
				Task[] tasks = taskDAO.getAllTasks();
				for(int i=0;i<tasks.length;i++)					
				{
					System.out.println(i+" : "+tasks[i]);
				}
				System.out.println("Enter task number : ");
				int number = scanner.nextInt();
				if(number > tasks.length)
					System.out.println("Task number is out of range...");
				else {
					scanner.nextLine();
				System.out.println("Enter name of user to whom to assign this task...");
				String user = scanner.nextLine();
				taskDAO.assignTask(number,user);
				System.out.println("Task successfully assigned...");
				}
				break;
			case 6:
				if (taskDAO.isEmpty()) {
					System.out.println("There is no task in array...");
				} else{
					tasks = taskDAO.getAllTasks();
					for(Task task: tasks)
					{
						System.out.println(task);
					}
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