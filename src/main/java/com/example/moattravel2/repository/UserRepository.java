package com.example.moattravel2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moattravel2.entity.User;

//method name, type of argument, type of returned value
public interface UserRepository extends JpaRepository<User, Integer>{

}
