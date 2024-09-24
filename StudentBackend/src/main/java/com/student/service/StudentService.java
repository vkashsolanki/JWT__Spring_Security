package com.student.service;

import java.util.List;

import com.student.model.Student;

public interface StudentService {
	
public Student saveStudent(Student student);

public List<Student> showAllStudent(); 

}
