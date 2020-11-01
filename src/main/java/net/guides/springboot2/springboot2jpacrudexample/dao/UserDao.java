package net.guides.springboot2.springboot2jpacrudexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.guides.springboot2.springboot2jpacrudexample.model.User;
import net.guides.springboot2.springboot2jpacrudexample.repository.UserRepository;

@Component
public class UserDao {

	@Autowired
	private UserRepository userRepo;
	
	public void addUser(User user) {
		userRepo.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	public User getUserByFirstName(String firstName) {
		return userRepo.findByFirstName(firstName);
	}
}
