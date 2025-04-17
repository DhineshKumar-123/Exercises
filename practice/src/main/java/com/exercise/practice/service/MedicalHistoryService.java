package com.exercise.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.practice.model.MedicalHistory;
import com.exercise.practice.repository.MedicalHistoryRepository;
@Service
public class MedicalHistoryService 
{

	@Autowired
	private MedicalHistoryRepository medicalHistoryRepository;
	
	public MedicalHistory addMedicalHistory(MedicalHistory medicalHistory) 
	{
		return medicalHistoryRepository.save(medicalHistory);
	}

}
