package net.guides.springboot2.springboot2jpacrudexample.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import net.guides.springboot2.springboot2jpacrudexample.dao.TeacherDao;
import net.guides.springboot2.springboot2jpacrudexample.model.Teacher;

public class TeacherService {

	@Autowired
	private TeacherDao teacherDao;
	
	public void addTeacher(Teacher teacher) {
		teacherDao.addTeacher(teacher);
	}
	
	public List<Teacher> getAllTeachers(){
		return teacherDao.getAllTeachers();
	}
}
