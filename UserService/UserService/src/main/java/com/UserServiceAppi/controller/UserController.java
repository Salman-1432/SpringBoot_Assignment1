package com.UserServiceAppi.controller;
import com.UserServiceAppi.model.User;

import com.UserServiceAppi.response.ResponseHandler;
import com.UserServiceAppi.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private  Userservice userservice;
    @Autowired
    public UserController(Userservice userservice)
    {

        this.userservice=userservice;
    }
    @GetMapping("/users/{userId}")
    //@ApiOperation(value="Cloud vender id",notes="Provide cloud vendor details",response= ResponseEntity.class)
    public ResponseEntity<Object> getUserDetails(@PathVariable("userId") String userId)
    {
        return ResponseHandler.responseBuilder("Requested User Details are given here",HttpStatus.OK,userservice.getUser(userId));
    }
    @GetMapping("/users")
    public List<User> getAllUserDetails()
    {
        return userservice.getAllUser();
    }
    //Read all cloud Vendor Details form DB
    @PostMapping("/users")
    public String createUserDetails(@RequestBody User user)
    {
        userservice.createUser(user);
        return "User Created Successfully";
    }
    @PutMapping("/users")
    public String updateUserDetails(@RequestBody User user)
    {
        userservice.updateUser(user);
        return "User Updated Successfully";
    }
    @DeleteMapping("/users/{userId}")
    public String deleteUserDetails(@PathVariable("userId") String userId)
    {
        userservice.deleteUser(userId);
        return "User Deleted Successfully";
    }
}
