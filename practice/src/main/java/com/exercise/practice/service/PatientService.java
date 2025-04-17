package com.exercise.practice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.exercise.practice.exception.InvalidUsernameException;
import com.exercise.practice.model.MedicalHistory;
import com.exercise.practice.model.Patient;
import com.exercise.practice.model.User;
import com.exercise.practice.repository.AuthRepository;
import com.exercise.practice.repository.MedicalHistoryRepository;
import com.exercise.practice.repository.PatientRepository;

@Service
public class PatientService 
{
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private AuthRepository authRepository;

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired
	private MedicalHistoryRepository medicalHistoryRepository;
	
	public Patient addPatient(Patient patient) 
	{
		User user1 = patient.getUser();
		User user = authRepository.findByUsername(user1.getUsername());
		if(user != null)
		{
			throw new InvalidUsernameException("Username already Exist !!!!");
		}
		if(user1.getRole() == null)
			user1.setRole("PATIENT");
		
		String encodedPass = bcrypt.encode(user1.getPassword());
		user1.setPassword(encodedPass);
		
		user1 = authRepository.save(user1);
		patient.setUser(user1);
		
		MedicalHistory medical = patient.getMedicalHistory();
		medical = medicalHistoryRepository.save(medical);
		patient.setMedicalHistory(medical);
		
		return patientRepository.save(patient);
	}

	public Patient getPatientByUsername(String username) 
	{
		return patientRepository.findByUserUsername(username);
	}

}
