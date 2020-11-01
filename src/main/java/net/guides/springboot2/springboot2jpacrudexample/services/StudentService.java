package net.guides.springboot2.springboot2jpacrudexample.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import net.guides.springboot2.springboot2jpacrudexample.dao.StudentDao;
import net.guides.springboot2.springboot2jpacrudexample.model.Student;

public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}
	
	public List<Student> getAllStudents(){
		return studentDao.getAllStudents();
	}
}
