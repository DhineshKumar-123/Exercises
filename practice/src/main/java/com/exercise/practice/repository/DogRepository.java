package com.exercise.practice.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.practice.model.Dog;

public interface DogRepository extends JpaRepository<Dog, Integer>
{


}
