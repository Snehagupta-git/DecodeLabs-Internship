package com.project2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project2.model.User;

@Service
public interface UserService {

	Object addUser(User user);

	List<User> getAllUsers();

	void deleteUser(int id);

}
