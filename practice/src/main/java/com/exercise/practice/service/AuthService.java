package com.exercise.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.exercise.practice.exception.InvalidUsernameException;
import com.exercise.practice.model.User;
import com.exercise.practice.repository.AuthRepository;
@Service
public class AuthService 
{
	@Autowired
	private AuthRepository authRepository;
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	public User signUp(User user) 
	{
		User user1 = authRepository.findByUsername(user.getUsername());
		if (user1 != null) 
		{
			// if user exists it will be not null. if its a new username then it will be
			// null
			throw new InvalidUsernameException("Username already exists");
		}
		if (user.getRole() == null)
			user.setRole("STUDENT");

		// encode the password for security purpose
		String encodedPass = bcrypt.encode(user.getPassword());
		// attach encoded password to user object
		user.setPassword(encodedPass);
		return authRepository.save(user);
	}

}
