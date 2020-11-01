package net.guides.springboot2.springboot2jpacrudexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.guides.springboot2.springboot2jpacrudexample.model.Student;
import net.guides.springboot2.springboot2jpacrudexample.repository.StudentRepository;

@Component
public class StudentDao {

	@Autowired
	private StudentRepository studentRepo;
	
	public void addStudent(Student student) {
		studentRepo.save(student);
	}
	
	public List<Student> getAllStudents(){
		return studentRepo.findAll();
	}
}
