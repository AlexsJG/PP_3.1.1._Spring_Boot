package com.Spring.dao;


import com.Spring.model.User;

import java.util.List;

public interface UserDao {

    List<User> allUsers();

    void addUser(User user);
    User updateUser(int id);

   void deleteUser(int id);
}

