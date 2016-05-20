package com.vasutin.service;

import java.util.List;

import com.vasutin.model.User;

public interface UserService {

	public void add(User user);
	public void edit(User user);
	public void delete(int id);
	public User getUser(int id);
	public List getAllUsers();

}
