package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest extends BaseDAOTest{
	
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void setUpClass() throws Exception {
		BaseDAOTest.setUpBeforeClass();
		userDAO = new UserDAO(entityManager);
		
	}

	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("tofgmmy11@gmail.com");
		user1.setFullName("Tommy11 Timothy");
		user1.setPassword("1abcdefghij");
			
		user1 = userDAO.create(user1);
		
		assertTrue(user1.getUserId() > 0);
	}
	
	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldsNotSet() {
		Users user1 = new Users();
		user1 = userDAO.create(user1);
		
	}
	
	@Test
	public void testUpdateUsers() {
		Users user = new Users();
		user.setUserId(1);
		user.setEmail("nam@codejava.net");
		user.setFullName("Nam Ha Minh");
		user.setPassword("mysecret");
		
		user = userDAO.update(user);
		String expected = "mysecret";
		String actual = user.getPassword();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetUsersFound() {
		Integer userId = 1;
		Users user = userDAO.get(userId);
		if (user != null) {
		System.out.println(user.getEmail());
		}
		assertNotNull(user);
	}
	
	@Test
	public void testGetUsersNotFound() {
		Integer userId = 99;
		Users user = userDAO.get(userId);
		
		assertNull(user);
	}
	
	@Test
	public void testDeleteUsers() {
		Integer userId = 8;
		userDAO.delete(userId);
		
		Users user = userDAO.get(userId);
		
		assertNull(user);
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteNonExistUsers() {
		Integer userId = 55;
		userDAO.delete(userId);
	}
	
	@Test
	public void testListAll() {
		List<Users> listUsers = userDAO.listAll();
		
		for(Users user : listUsers) {
			System.out.println(user.getEmail());
		}
		
		assertTrue(listUsers.size() > 0);
	}
	
	@Test
	public void testCount() {
		long totalUsers = userDAO.count();
		
		assertEquals(7, totalUsers);
	}
	
	@Test
	public void testFindByEmail() {
		String email = "nam@codejava.net";
		Users user = userDAO.findByEmail(email);
		
		assertNotNull(user);
	}
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}
	
}