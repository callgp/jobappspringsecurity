package com.dao;


import com.telusko.JobApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

 public  User findByUsername(String username);
}
