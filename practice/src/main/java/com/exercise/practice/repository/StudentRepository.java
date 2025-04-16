package com.exercise.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.practice.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>
{

}
