package com.exercise.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.practice.model.MedicalHistory;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Integer>
{
	

}
