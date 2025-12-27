package com.Spring.service;


import com.Spring.model.User;

import java.util.List;

public interface UserService {

    List<User> allUsers();

    void addUser(User user);

    User updateUser(int id);

    void deleteUser(int id);
}
