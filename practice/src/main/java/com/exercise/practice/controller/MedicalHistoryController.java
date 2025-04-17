package com.exercise.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.practice.model.MedicalHistory;
import com.exercise.practice.service.MedicalHistoryService;

@RestController
@RequestMapping("/api/medicalhistory")
public class MedicalHistoryController
{

	@Autowired
	private MedicalHistoryService medicalHistoryService;
	
	public MedicalHistory addMedicalHistory(@RequestBody MedicalHistory medicalHistory)
	{
		return medicalHistoryService.addMedicalHistory(medicalHistory);
	}
}
