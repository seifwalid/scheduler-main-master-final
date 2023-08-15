package com.spring.scheduler.scheduler.service;

import java.util.List;

import com.spring.scheduler.scheduler.model.User;

public interface UserService {

    public List<User> getAllUsers();

    public User getUser(long id);

    public User saveUser(User user);

    public void deleteUser(long id);

    public User updateUser(User updatedUser, long id);

}
