package com.gl.week1.day4dao;

import com.gl.week1.day4.model.User;

public interface UserDAO {
	boolean isFull();
	boolean isEmpty();
	boolean registerUser(User user);
	User loginWithNameAndPassword(String name,String password);
	User[] getAllUsers();
	User[] getAllVisitorName();
//	User loginWithNameAndPassword();
}