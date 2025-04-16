package com.exercise.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.practice.model.Student;
import com.exercise.practice.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController 
{
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student)
	{
		return studentService.addStudent(student);
		
	}

}
