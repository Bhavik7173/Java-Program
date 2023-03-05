package com.gl.week1.day4.tester;

import java.io.ObjectInputFilter.Status;
import java.util.Scanner;
import com.gl.week1.day4.model.Task;
import com.gl.week1.day4.model.User;
import com.gl.week1.day4dao.TaskDAO;
import com.gl.week1.day4dao.TaskDAOImpl;
import com.gl.week1.day4dao.UserDAO;
import com.gl.week1.day4dao.UserDAOImpl;

public class Week4Tester {
	Scanner scanner;
	TaskDAO taskDAO;
	UserDAO userDAO = null;

	public User getUser() {
		System.out.println("Enter user name : ");
		String name = scanner.next();

		System.out.println("Enter user password : ");
		String password = scanner.next();

		System.out.println("Enter user type (visitor/client) : ");
		String type = scanner.next();

		User user = new User(name, password, type);
		return user;
	}

	public Week4Tester() {
		scanner = new Scanner(System.in);
		taskDAO = new TaskDAOImpl();
		userDAO = new UserDAOImpl(10);
	}

	public static void main(String[] args) {
		Week4Tester tester = new Week4Tester();
		tester.userMenu();
	}

	public Task readTask(String clientName) {
		scanner.nextLine();
		System.out.println("Enter new task Title ... ");
		String taskTitle = scanner.nextLine();

		System.out.println("Enter new task description... ");
		String taskText = scanner.nextLine();

		Task task = new Task(taskTitle, taskText, clientName);
		return task;
	}

	public void userMenu() {
		int ch = 0;

		do {
			System.out.println("1. Register...");
			System.out.println("2. Login...");
			System.out.println("0. Exit");

			System.out.print("Enter your choice : ");
			ch = scanner.nextInt();

			switch (ch) {
			case 1:
				if (userDAO.isFull())
					System.out.println("Task array is full...");
				else {
					boolean status = userDAO.registerUser(getUser());
					if (status)
						System.out.println("user registered...");
					else
						System.out.println("registration failed...,please try again...");
				}
				break;
			case 2:
				if (userDAO.isEmpty()) {

				} else {
					System.out.println("Enter user name : ");
					String name = scanner.next();

					System.out.println("Enter user password : ");
					String password = scanner.next();

					User user = userDAO.loginWithNameAndPassword(name, password);

					if (user != null) {
						if (user.getType().equals("client")) {
							taskMenu(user.getName());
						} else if (user.getType().equals("visitor")) {
							Task[] tasks = taskDAO.getAllTaskByUser(user.getName());
							if (tasks.length == 0)
								System.out.println("there is no task assign to you...");
							else {
								for (Task task : tasks) {
									System.out.println(task);
								}
							}
						}
					} else {
						System.out.println("name and password does not match!!!");
					}
				}
				break;
			case 3:
				User[] users = userDAO.getAllUsers();
				for (User user : users) {
					System.out.println(user);
				}
			case 0:
				System.out.println("Good bye!!!");
				break;
			default:
				System.out.println("please check your input!!!");
			}
		} while (ch != 0);

	}

	public void taskMenu(String clientName) {
		int ch = 0;
		int n;
		Task[] tasks;
		do {
			System.out.println("1. Insert new Task");
			System.out.println("2. Delete a Task");
			System.out.println("3. Update a Task");
			System.out.println("4. Search for a Task");
			System.out.println("5. Assign Task to a Visitor");
			System.out.println("6. Display task");
			System.out.println("0. Exit");

			System.out.print("Enter your choice : ");
			ch = scanner.nextInt();

			switch (ch) {
			case 1:
				if (taskDAO.isFull())
					System.out.println("Tasks array is overflow!!! you can not insert any more task...");
				else {
					n = taskDAO.insertTask(readTask(clientName));

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

					n = taskDAO.deleteTask(taskTitle, clientName);
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
					n = taskDAO.updateTask(readTask(clientName));
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

					n = taskDAO.searchTask(taskTitle, clientName);
					if (n == -1)
						System.out.println("Task not found");
					else
						System.out.println("Your task is on position : " + (n + 1));
				}
				break;
			case 5:
				tasks = taskDAO.getAllTaskByUser(clientName);
				if (tasks.length == 0)
					System.out.println("Sorry there are no task ...");
				else {
					for (Task task : tasks) {
						System.out.println(task);
					}
					System.out.println("Enter task number to assign...");
					int taskNumber = scanner.nextInt();

					User[] visitors = userDAO.getAllVisitorName();
					for (User user : visitors) {
						System.out.println(user.getName());
					}
					System.out.println("Enter visitor number to assign...");
					int visitorNumber = scanner.nextInt();

					boolean status = taskDAO.assignTaskToVisitor(tasks[taskNumber], visitors[visitorNumber].getName());
					if (status)
						System.out.println("task assigned to visitor...");
					else
						System.out.println("can not assign task to visitor...");
				}
				break;
			case 6:
				tasks = taskDAO.getAllTaskByUser(clientName);
				if (tasks.length == 0)
					System.out.println("Sorry there are no task ...");
				else {
					for (Task task : tasks) {
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