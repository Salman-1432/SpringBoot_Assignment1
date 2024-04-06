package com.UserServiceAppi.repository;

import com.UserServiceAppi.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import java.util.List;

@DataJpaTest
public class userRepositoryTest{
    @Autowired
    private UserRepository userRepository;
    User user ;
    @BeforeEach
    void setUp()
    {
        user =new User("1","Shadab","Moradabad","897979");
        userRepository.save(user);
    }
    @AfterEach
    void tearDown()
    {
        //user=null;
        //userRepository.deleteAll();
    }
    //Test case Success
    @Test
    void testFindByUserName_Found()
    {
        List<User> userList=userRepository.findByUserName("Shadab");
        assertThat(userList.get(0).getUserId()).isEqualTo(user.getUserId());
        assertThat(userList.get(0).getUserAddress())
                .isEqualTo(user.getUserAddress());

    }
    @Test
    void testFindByUserName_NotFound()
    {
        List<User> userList=userRepository.findByUserName("GCP");
        assertThat(userList.isEmpty()).isTrue();
    }
}
