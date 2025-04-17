package com.exercise.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.practice.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>
{

	Patient findByUserUsername(String username);
}
