package com.exercise.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.practice.model.Patient;
import com.exercise.practice.service.PatientService;


@RestController
@RequestMapping("/api/patient")
public class PatientController
{
	@Autowired
	private PatientService patientService;

	@PostMapping("/add")
	public Patient addPatient(@RequestBody Patient patient)
	{
		return patientService.addPatient(patient);
	}
	
	@GetMapping("/getpatient/{username}")
	public Patient getPatientByUsername(@PathVariable String username)
	{
		return patientService.getPatientByUsername(username);
	}

}
