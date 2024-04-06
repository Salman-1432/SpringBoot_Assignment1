package com.UserServiceAppi.service.Impl;

import com.UserServiceAppi.exception.UserNotFoundException;
import com.UserServiceAppi.model.User;
import com.UserServiceAppi.repository.UserRepository;
import com.UserServiceAppi.service.Userservice;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements Userservice {

    UserRepository userRepository;
    public  UserServiceImpl(UserRepository userRepository)
    {

        this.userRepository=userRepository;
    }
    @Override
    public String createUser(User user) {
        //More Business Logic
        userRepository.save(user);
        return "Success";
    }

    @Override
    public String updateUser(User user) {
        userRepository.save(user);
        return "Success";
    }

    @Override
    public String deleteUser(String userId) {
        userRepository.deleteById(userId);
        return "Success";
    }

    @Override
    public User getUser(String userId) {
        if(userRepository.findById(userId).isEmpty())
            throw new UserNotFoundException("User does not exist");
        return userRepository.findById(userId).get();
    }

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public List<User> getByUserName(String userName) {

        return userRepository.findByUserName(userName);
    }
}
