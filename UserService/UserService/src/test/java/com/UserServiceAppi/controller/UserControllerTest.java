package com.UserServiceAppi.controller;

import com.UserServiceAppi.model.User;
import com.UserServiceAppi.service.Userservice;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private Userservice userservice;
    User userOne;
    User userTwo;
    List<User> userList=new ArrayList<>();
    @BeforeEach
    void setUp()
    {
        userOne=new User("1","salman","Rampur","97592");
        userTwo=new User("2","Suleman","Haldwani","889967");
        userList.add(userOne);
        userList.add(userTwo);
    }
    @AfterEach
    void tearDown()
    {

    }
    @Test
    void getUserDetails() throws  Exception
    {
        when(userservice.getUser("1")).thenReturn(userOne);
        this.mockMvc.perform(get("/users/1")).andDo(print()).andExpect(status().isOk());
    }
    @Test
    void getAllUser()throws Exception
    {
        when(userservice.getAllUser()).thenReturn(userList);
        this.mockMvc.perform(get("/users"))
                .andDo(print()).andExpect(status().isOk());

    }
    @Test
    void createUserDetails() throws Exception
    {
        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
        ObjectWriter ow=mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(userOne);

        when(userservice.createUser(userOne)).thenReturn("Success");
        this.mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print()).andExpect(status().isOk());

    }
    @Test
    void updateUserDetails() throws Exception
    {
        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
        ObjectWriter ow=mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(userOne);

        when(userservice.createUser(userOne)).thenReturn("Success");
        this.mockMvc.perform(put("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                        .andDo(print()).andExpect(status().isOk());

    }
    @Test
    void deleteUserDetails()throws Exception
    {
        when(userservice.deleteUser("1"))
                .thenReturn("User Deleted Successfully");
        this.mockMvc.perform(delete("/users/1"))
                .andDo(print()).andExpect(status().isOk());
    }

}
