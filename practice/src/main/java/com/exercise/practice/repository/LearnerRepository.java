package com.exercise.practice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.practice.model.Learner;

public interface LearnerRepository extends JpaRepository<Learner, Integer>
{

	Optional<Learner> findByUserUsername(String username);
	
}
