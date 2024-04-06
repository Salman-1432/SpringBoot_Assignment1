package com.UserServiceAppi.service;
import com.UserServiceAppi.model.User;

import java.util.List;

public interface Userservice {
    public String createUser(User user);
    public String updateUser(User user);
    public String deleteUser(String userId);
    public User getUser(String userId);
    public List<User> getAllUser();
    public List<User> getByUserName(String userName);

}
