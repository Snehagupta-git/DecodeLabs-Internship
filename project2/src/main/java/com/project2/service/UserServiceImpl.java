package com.project2.service;

import com.project2.model.User;
import com.project2.service.UserService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service   // ✅ THIS IS IMPORTANT
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();

    @Override
    public Object addUser(User user) {

        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new RuntimeException("Invalid Data!");
        }

        users.add(new User(users.size() + 1, user.getName(), user.getAge()));

        return users;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void deleteUser(int id) {

        boolean exists = users.stream().anyMatch(u -> u.getId() == id);

        if (!exists) {
            throw new RuntimeException("User not found");
        }

        users.removeIf(u -> u.getId() == id);
    }
}