package net.guides.springboot2.springboot2jpacrudexample.service.test;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import net.guides.springboot2.springboot2jpacrudexample.dao.UserDao;
import net.guides.springboot2.springboot2jpacrudexample.model.User;
import net.guides.springboot2.springboot2jpacrudexample.repository.UserRepository;
import net.guides.springboot2.springboot2jpacrudexample.services.UserService;

@RunWith(SpringRunner.class)
/*
 * @RunWith(SpringRunner.class) provides a bridge between Spring Boot test features and JUnit. 
 * Whenever we are using any Spring Boot testing features in our JUnit tests, this annotation 
 * will be required.
 * */
@DataJpaTest
public class UserServiceIntegrationTest {

	@TestConfiguration
    static class UserServiceImplTestContextConfiguration {
 
        @Bean
        public UserService userService() {
            return new UserService();
        }
        
		/*
		 * @Bean public UserDao userDao() { return new UserDao(); }
		 */
    }
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Autowired
    private UserService userService;
	
	@MockBean
	private UserDao userDao;
 
    @MockBean
    private UserRepository userRepository;
    
	/*
	 * @Before public void setUp() { User entity = new User();
	 * entity.setFirstName("alex"); entity.setLastName("hale");
	 * entity.setEmail("qasimalee@gmail.com"); entity.setPassword("Kuubitt");
	 * entity.setCreatedAt(new Date()); userRepository.save(entity);
	 * System.out.println("Entity Saved");
	 * 
	 * }
	 */
    
    @Test
    public void whenValidName_thenUserShouldBeFound() {
    	User entity = new User();
    	entity.setFirstName("alex");
    	entity.setLastName("hale");
    	entity.setEmail("qasimalee@gmail.com");
    	entity.setPassword("Kuubitt");
    	entity.setCreatedAt(new Date());
    	entity.setCreatedBy(new User());
    	testEntityManager.persistAndFlush(entity);
    	//userRepository.save(entity);
    	System.out.println("Entity Saved");
    	String name = "alex";
        User found = userRepository.findByFirstName(name);
     
         assertEquals(name, found.getFirstName());
     }
}
