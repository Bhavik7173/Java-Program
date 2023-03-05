package com.gi.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.gi.dao.UserDAO;
import com.gi.model.User;

public class UserDAOImpl implements UserDAO {
	private List<User> users;
	private static UserDAOImpl userImpl = null;
	int id;

	private UserDAOImpl() {
		users = new ArrayList<>();
	}

	public static synchronized UserDAOImpl getUserDAOImpl() {
		if (userImpl == null) {
			userImpl = new UserDAOImpl();
		}
		return userImpl;
	}

	@Override
	public User login(String email, String pass) {
		for (User user : users) {
			if (user.getEmail().equals(email) && user.getPassword().equals(pass)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public boolean register(User user) {
		try {
			id = users.get(users.size() - 1).getId();
			user.setId(id + 1);

		} catch (Exception e) {
			id = 0;
		}
		return users.add(user);
	}
}
