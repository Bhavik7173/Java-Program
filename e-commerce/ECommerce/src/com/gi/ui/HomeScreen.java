package com.gi.ui;

import java.util.Scanner;

public class HomeScreen {
	public static void main(String[] args) {
		int ch = 0;
		AdminScreen ad = new AdminScreen();
		UserScreen user = new UserScreen();
		
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1.Admin");
			System.out.println("2.User");
			System.out.println("0.Exit");

			System.out.println("Enter your choice : ");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				ad.adminMenu();
				break;
			case 2:
				user.userMenu();
				break;
			case 0:
				System.out.println("Thanks");
				break;

			default:
				System.out.println("invlalid option");
			}
		} while (ch != 0);
	}
}
