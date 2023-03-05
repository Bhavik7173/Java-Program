package com.gi.dao;

import com.gi.model.User;

public interface UserDAO {
	boolean register(User user);
	User login(String email,String pass);
}
