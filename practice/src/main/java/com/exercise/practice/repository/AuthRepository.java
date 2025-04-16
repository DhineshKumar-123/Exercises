package com.exercise.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.practice.model.User;

public interface AuthRepository extends JpaRepository<User, Integer>
{

	User findByUsername(String username);

	
}
