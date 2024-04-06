package com.UserServiceAppi.repository;

import com.UserServiceAppi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface UserRepository extends JpaRepository<User,String> {
    List<User> findByUserName(String userName);

}
