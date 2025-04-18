package com.exercise.practice.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.exercise.practice.exception.InvalidUsernameException;
import com.exercise.practice.model.Address;
import com.exercise.practice.model.Learner;
import com.exercise.practice.model.User;
import com.exercise.practice.repository.AddressRepository;
import com.exercise.practice.repository.AuthRepository;
import com.exercise.practice.repository.LearnerRepository;

@Service
public class LearnerService 
{
	@Autowired
	private LearnerRepository learnerRepository;
	@Autowired
	private AuthRepository authRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	public Learner addLearnerWithAddress(Learner learner) 
	{
		//Get user details from the requestbody
		User user = learner.getUser();
		User user1 = authRepository.findByUsername(user.getUsername());
		//checks username exist already or not
		if(user1 != null)
		{
			throw new InvalidUsernameException("User Already Eixist in Learner !!!");
		}
		if(user.getRole() == null)
			user.setRole("LEARNER");
		
		String encodedPassword = bcrypt.encode(user.getPassword());
		user.setPassword(encodedPassword);
		//Get address details from the requestbody
		Address address = learner.getAddress();
		//save it in user repo
		authRepository.save(user);
		//save it in address repo
		addressRepository.save(address);
		//attach user and address into learner
		learner.setUser(user);
		learner.setAddress(address);
		//save learner in learner repo		
		return learnerRepository.save(learner);
	}

	public Learner getLearnerByUsername(String username) 
	{
		Optional<Learner> optional = learnerRepository.findByUserUsername(username);
		if(optional.isEmpty())
		{
			throw new InvalidUsernameException("Username Not Found");
		}
		return optional.get();
	}
	
}
