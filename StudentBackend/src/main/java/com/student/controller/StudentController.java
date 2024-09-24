package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.service.StudentServiceImpl;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentServiceImpl impl;

	@PostMapping("/add")
	public Student save(@RequestBody Student students) {
		
		return impl.saveStudent(students);
		
	}
	@GetMapping("/show")
	public List<Student> showStudent() {
		return impl.showAllStudent();
		
	}
	
}
