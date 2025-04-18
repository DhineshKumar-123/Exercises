package com.exercise.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.practice.model.Learner;
import com.exercise.practice.service.LearnerService;

@RestController
public class LearnerController 
{
	//Post Api for take Learner details along with users and address also
	
	@Autowired
	private LearnerService learnerService;
	
	@PostMapping("/api/learner/add")
	public Learner addLearnerWithAddress(@RequestBody Learner learner)
	{
		return learnerService.addLearnerWithAddress(learner);
	}
	
	@GetMapping("/api/learner/findbyusername/{username}")
	public Learner getLearnerByUsername(@PathVariable String username)
	{
		return learnerService.getLearnerByUsername(username);
	}

}
