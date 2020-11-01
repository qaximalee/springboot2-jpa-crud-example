package net.guides.springboot2.springboot2jpacrudexample.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.guides.springboot2.springboot2jpacrudexample.dao.UserDao;
import net.guides.springboot2.springboot2jpacrudexample.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}
	
	public User getUserByFirstName(String firstName) {
		return userDao.getUserByFirstName(firstName);
	}
}
