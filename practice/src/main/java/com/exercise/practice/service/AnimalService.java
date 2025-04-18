package com.exercise.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.practice.exception.InvalidUsernameException;
import com.exercise.practice.model.Animal;
import com.exercise.practice.model.Cat;
import com.exercise.practice.model.Dog;
import com.exercise.practice.repository.AnimalRepository;
import com.exercise.practice.repository.CatRepository;
import com.exercise.practice.repository.DogRepository;


@Service
public class AnimalService 
{

	@Autowired
	private AnimalRepository animalRepository;
	@Autowired
	private CatRepository catRepository;
	@Autowired
	private DogRepository dogRepository;
	
	public List<Animal> getAnimalByDogName(String dogname) 
	{
		return animalRepository.findByDogDogname(dogname);
	}
	
	public Animal getAnimalByCatName(String catname) 
	{
		Optional<Animal> optional  = animalRepository.findByCatCatname(catname);
		if(optional.isEmpty())
		{
			throw new InvalidUsernameException("Entered cat name is not found");
		}
		return optional.get();
	}

	public List<Animal> getAnimalByDogId(int did) 
	{
		return animalRepository.findByDogId(did);
	}

	public Animal addAnimal(Animal animal) 
	{
		Dog dog = animal.getDog();
		Cat cat = animal.getCat();
		
		dogRepository.save(dog);
		catRepository.save(cat);
		
		animal.setCat(cat);
		animal.setDog(dog);
		
		
		return animalRepository.save(animal);
	}

}
