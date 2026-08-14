package com.jwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jwt.model.Users;


public interface UserRepo extends JpaRepository<Users,Integer> {

    Users findByUsername(String username);

    @Query("SELECT u.username FROM Users u")
    List<String> findAllUsernameList();

}
