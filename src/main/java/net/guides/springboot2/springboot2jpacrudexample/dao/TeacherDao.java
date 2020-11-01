package net.guides.springboot2.springboot2jpacrudexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.guides.springboot2.springboot2jpacrudexample.model.Teacher;
import net.guides.springboot2.springboot2jpacrudexample.repository.TeacherRepository;

@Component
public class TeacherDao {
	
	@Autowired
	private TeacherRepository teacherRepo;
	
	public void addTeacher(Teacher teacher) {
		teacherRepo.save(teacher);
	}
	
	public List<Teacher> getAllTeachers(){
		return teacherRepo.findAll();
	}
}
