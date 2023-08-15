package com.spring.scheduler.scheduler.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.scheduler.scheduler.exception.ResourceNotFoundException;
import com.spring.scheduler.scheduler.model.User;
import com.spring.scheduler.scheduler.repository.UserRepository;
import com.spring.scheduler.scheduler.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User updatedUser, long id) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "ID", id));

        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setPassword(updatedUser.getPassword());

        return userRepository.save(existingUser);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "ID", id));
        return existingUser;
    }
}
