package com.UserServiceAppi.service.Impl;

import com.UserServiceAppi.model.User;
import com.UserServiceAppi.repository.UserRepository;
import com.UserServiceAppi.service.Userservice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


public class UserServiceImplTest{
    @Mock
    private UserRepository userRepository;
    private Userservice userservice;
    AutoCloseable autoCloseable;
    User user;
    @BeforeEach
    void setUp()
    {
        autoCloseable = MockitoAnnotations.openMocks(this);
        userservice = new UserServiceImpl(userRepository);
        user = new User("1", "Amazon",
                "USA", "23455");
    }
    @AfterEach
    void tearDown()throws Exception
    {
        autoCloseable.close();
    }
    @Test
    void testCreateUser() {
        mock(User.class);
        mock(UserRepository.class);

        when(userRepository.save(user)).thenReturn(user);
        assertThat(userservice.createUser(user)).isEqualTo("Success");

    }
    @Test
    void testUpdateUser() {
        mock(User.class);
        mock(UserRepository.class);

        when(userRepository.save(user)).thenReturn(user);
        assertThat(userservice.updateUser(user)).isEqualTo("Success");
    }
    @Test
    void testDeleteUser() {
        mock(User.class);
        mock(UserRepository.class, Mockito.CALLS_REAL_METHODS);

        doAnswer(Answers.CALLS_REAL_METHODS).when(userRepository)
                .deleteById(any());
        assertThat(userservice.deleteUser("1")).isEqualTo("Success");
    }
    @Test
    void testGetUser() {
        mock(User.class);
        mock(UserRepository.class);

        when(userRepository.findById("1")).thenReturn(Optional.ofNullable(user));

        assertThat(userservice.getUser("1").getUserName())
                .isEqualTo(user.getUserName());
    }
    @Test
    void testGetByUserName() {
        mock(User.class);
        mock(UserRepository.class);

        when(userRepository.findByUserName("Amazon")).
                thenReturn(new ArrayList<User>(Collections.singleton(user)));

        assertThat(userservice.getByUserName("Amazon").get(0).getUserId()).
                isEqualTo(user.getUserId());
    }
    @Test
    void testGetAllUser() {
        mock(User.class);
        mock(UserRepository.class);

        when(userRepository.findAll()).thenReturn(new ArrayList<User>(
                Collections.singleton(user)
        ));

        assertThat(userservice.getAllUser().get(0).getUserPhoneNum()).
                isEqualTo(user.getUserPhoneNum());

    }

}
