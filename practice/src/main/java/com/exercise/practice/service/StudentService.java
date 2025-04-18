package com.exercise.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.exercise.practice.exception.InvalidUsernameException;
import com.exercise.practice.model.Student;
import com.exercise.practice.model.User;
import com.exercise.practice.repository.AuthRepository;
import com.exercise.practice.repository.StudentRepository;
@Service
public class StudentService 
{
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private AuthRepository authRepository;
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	
	public Student addStudent(Student student) 
	{
		User user1 = student.getUser();
		User user = authRepository.findByUsername(user1.getUsername());
		if(user != null)
		{
			throw new InvalidUsernameException("Username already Exist !!!!");
		}
		if(user1.getRole() == null)
			user1.setRole("STUDENT");
		
		String encodedPass = bcrypt.encode(user1.getPassword());
		user1.setPassword(encodedPass);
		
		authRepository.save(user1);
		student.setUser(user1);
		
		return studentRepository.save(student);
	}

}
