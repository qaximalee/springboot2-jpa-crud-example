package net.guides.springboot2.springboot2jpacrudexample.repository.test;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
/*
 * @RunWith(SpringRunner.class) provides a bridge between Spring Boot test features and JUnit. 
 * Whenever we are using any Spring Boot testing features in our JUnit tests, this annotation 
 * will be required.
 * */
@DataJpaTest
/*
 * @DataJpaTest provides some standard setup needed for testing the persistence layer:
 * i.   configuring H2, an in-memory database
 * ii.  setting Hibernate, Spring Data, and the DataSource
 * iii. performing an @EntityScan
 * iv.  turning on SQL logging
*/
public class EmployeeRepositoryIntegrationTest {
 
	/*
	 * To carry out DB operations, we need some records already in our database. To setup this data, we can use TestEntityManager.*/
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private EmployeeRepository employeeRepository;
 
 
    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        Employee alex = new Employee("alex");
        entityManager.persist(alex);
        entityManager.flush();
     
        // when
        Employee found = employeeRepository.findByName(alex.getName());
     
        // then
        Assert.assertEquals(found.getName(), alex.getName());
    }
}
