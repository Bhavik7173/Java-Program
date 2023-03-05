package com.gi.test;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		int ch = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1. insert new Employee");
			System.out.println("2. delete an Employee");
			System.out.println("3. udpate an Employee");
			System.out.println("4. serach for an Employee (id based)");
			System.out.println("5. Disp all Employees");
			System.out.println("6. Exit");
			System.out.println("Enter your choice : ");
			ch = sc.nextInt();
			
			switch (ch) {
			case 1: 
				break;
			case 2: 
				break;
			case 3:
				break;
			case 4: 
				break;
			case 5: 
				break;
			case 6:
				System.out.println("bye");
				break;
 			default:
				System.out.println("Invalid choice");
			}
		} while (ch!=6);
	}
}
