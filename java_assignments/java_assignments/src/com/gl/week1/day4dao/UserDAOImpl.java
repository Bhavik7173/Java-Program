package com.gl.week1.day4dao;

import java.util.Scanner;
import com.gl.week1.day4.model.User;

public class UserDAOImpl implements UserDAO {
	Scanner scanner;
	User[] users;
	int cnt = 0;

	public boolean isEmpty() {
		if (cnt == 0)
			return true;
		return false;
	}

	public boolean isFull() {
		if (cnt == users.length)
			return true;
		return false;
	}

	public UserDAOImpl(int size) {
		scanner = new Scanner(System.in);
		users = new User[size];
	}

	@Override
	public boolean registerUser(User user) {
		if (searchUser(user.getName())) {
			return false;
		} else {
			users[cnt] = user;
			cnt++;
			return true;
		}
	}

	@Override
	public User loginWithNameAndPassword(String name, String password) {
		for (int i = 0; i < cnt; i++) {
			if (users[i].getName().equals(name) && users[i].getPassword().equals(password)) {
				return users[i];
			}
		}
		return null;
	}

	boolean searchUser(String name) {
		for (int i = 0; i < cnt; i++) {
			if (users[i].getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public User[] getAllVisitorName() {
		User[] visitors = new User[cnt];
		int index = 0;
		for (int i = 0; i < cnt; i++) {
			if (users[i].getType().equalsIgnoreCase("visitor")) {
				visitors[index++] = users[i];
			}
		}
		return visitors;
	}

	@Override
	public User[] getAllUsers() {
		User[] users = new User[cnt];
		for(int i=0;i<cnt;i++)
		{
			users[i] = this.users[i];
		}
		return users;
	}
}