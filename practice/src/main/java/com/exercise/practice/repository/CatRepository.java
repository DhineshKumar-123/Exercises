package com.exercise.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.practice.model.Cat;

public interface CatRepository extends JpaRepository<Cat, Integer>
{

}
