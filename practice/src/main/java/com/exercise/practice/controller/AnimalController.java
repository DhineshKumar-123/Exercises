package com.exercise.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.practice.model.Animal;

import com.exercise.practice.service.AnimalService;

@RestController
public class AnimalController 
{


	@Autowired
	private AnimalService animalService;
	
	//Get Animal by Dog Name
	@GetMapping("/api/animal/getbydname/{dogname}")
	public List<Animal> getAnimalByDogName(@PathVariable String dogname)
	{
		return animalService.getAnimalByDogName(dogname);
	}
	
	//Get Animal by Cat Name
	@GetMapping("/api/animal/getbycname/{catname}")
	public Animal getAnimalByCatName(@PathVariable String catname)
	{
		return animalService.getAnimalByCatName(catname);
	}

	//Get Animal By Dog id
	@GetMapping("/api/animal/getbydogid/{did}")
	public List<Animal> getAnimalByDogId(@PathVariable int did)
	{
		return animalService.getAnimalByDogId(did);
	}
	
	//Add the details of dog and cat into the Animal in db
	
	@PostMapping("/api/animal/add")
	public Animal addAnimal(@RequestBody Animal animal)
	{
		return animalService.addAnimal(animal);
	}
	
	
	
	
	
	
	
	
	
}
