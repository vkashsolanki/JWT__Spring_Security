package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepository;
	
	
	//save student data in database
	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	//fetch data from database data
	@Override
	public List<Student> showAllStudent() {
		
		return studentRepository.findAll();
	}

}
