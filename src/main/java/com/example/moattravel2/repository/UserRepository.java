package com.example.moattravel2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moattravel2.entity.User;

//method name, type of argument, type of returned value
public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByEmail(String email);
	public Page<User> findByNameLikeOrFuriganaLike(String nameKeyword, String furiganaKeyword, Pageable pageable);

}
