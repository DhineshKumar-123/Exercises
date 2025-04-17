package com.exercise.practice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MedicalHistory 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String illness;
	
	@Column(nullable = false)
	private int numofYears;
	
	@Column(nullable = false,length = 1000)
	private String currentMedication;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIllness() {
		return illness;
	}
	public void setIllness(String illness) {
		this.illness = illness;
	}
	public int getNumofYears() {
		return numofYears;
	}
	public void setNumofYears(int numofYears) {
		this.numofYears = numofYears;
	}
	public String getCurrentMedication() {
		return currentMedication;
	}
	public void setCurrentMedication(String currentMedication) {
		this.currentMedication = currentMedication;
	}
	
	

}
