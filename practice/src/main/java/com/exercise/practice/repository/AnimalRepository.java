package com.exercise.practice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.practice.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer>
{

	List<Animal> findByDogDogname(String dogname);

	Optional<Animal> findByCatCatname(String catname);

	List<Animal> findByDogId(int did);

	

	

}
