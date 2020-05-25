package com.bookstore.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.hibernate.jdbc.Expectation;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookDAOTest extends BaseDAOTest {
	private static BookDAO bookDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BaseDAOTest.setUpBeforeClass();
		bookDao = new BookDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteBookFail() {
		Integer bookId = 100;
		bookDao.delete(bookId);
		assertTrue(true);
	}
	
	@Test
	public void testListAll() {
		List<Book> listBooks = bookDao.listAll();
		
		for (Book aBook : listBooks) {
			System.out.println(aBook.getTitle() + " - " + aBook.getAuthor());
		}
		
		assertFalse(listBooks.isEmpty());
	}
	
	@Test
	public void testFindByTitleNotExists() {
		String title = "Thinking in Java";
		Book book = bookDao.findByTitle(title);
		
		assertNull(book);
	}
	
	@Test
	public void testFindByTitleExists() {
		String title = "Java 8 in Action";
		Book book = bookDao.findByTitle(title);
		
		System.out.println(book.getAuthor());
		System.out.println(book.getPrice());
		
		assertNotNull(book);
	}
	
	@Test
	public void testCount() {
		long totalBooks = bookDao.count();
		
		assertEquals(2,totalBooks);
	}
	

	@Test
	public void testDeleteBookSuccess() {
		Integer bookId = 5;
		bookDao.delete(bookId);
		assertTrue(true);
	}
	
	@Test
	public void testGetBookFail() {
		Integer bookId = 99;
		Book book = bookDao.get(bookId);
		
		assertNull(book);
	}
	
	@Test
	public void testGetBookSuccess() {
		Integer bookId = 6;
		Book book = bookDao.get(bookId);
		
		assertNotNull(book);
	}
	

	@Test
	public void testUpdateBook() throws ParseException, IOException {
		Book existBook = new Book();
		existBook.setBookId(5);
		
		Category category = new Category("Web Design");
		category.setCategoryId(1);
		existBook.setCategory(category);
		
		existBook.setTitle("Effectiveee Java (3rd Edition)");
		existBook.setAuthor("Joshua Blach");
		existBook.setDescription("New coverage of generics, enums, annotations, autoboxing");
		existBook.setPrice(40f);
		existBook.setIsbn("0321356683");
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate = dateFormat.parse("05/28/2008");
		existBook.setPublishTime(publishDate);
		
		String imagePath = "C:\\Users\\piyus\\Desktop\\BookStoreWebsite Images\\java.JPG";
		
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		existBook.setImage(imageBytes);
		
		Book updatedBook = bookDao.update(existBook);
		
		assertEquals(updatedBook.getTitle(),"Effectiveee Java (3rd Edition)");
	}
	
	
	
	@Test
	public void testCreateBook() throws ParseException, IOException {
		Book newBook = new Book();
		
		Category category = new Category("Python");
		category.setCategoryId(16);
		newBook.setCategory(category);
		
		newBook.setTitle("Effectiveee Java (2nd Edition)");
		newBook.setAuthor("Joshua Blach");
		newBook.setDescription("New coverage of generics, enums, annotations, autoboxing");
		newBook.setPrice(38.87f);
		newBook.setIsbn("0321356683");
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate = dateFormat.parse("05/28/2008");
		newBook.setPublishTime(publishDate);
		
		String imagePath = "C:\\Users\\piyus\\Desktop\\BookStoreWebsite Images\\java.JPG";
		
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newBook.setImage(imageBytes);
		
		Book createBook = bookDao.create(newBook);
		
		assertTrue(createBook.getBookId() > 0);
	}
	
	@Test
	public void testCreate2ndBook() throws ParseException, IOException {
		Book newBook = new Book();
		
		Category category = new Category("Advance Java");
		category.setCategoryId(2);
		newBook.setCategory(category);
		
		newBook.setTitle("Java 8 in Action");
		newBook.setAuthor("Alan Mycroft");
		newBook.setDescription("Java 8 in Action is a clearly written guide to the new Features of java 8");
		newBook.setPrice(36.72f);
		newBook.setIsbn("167291994");
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate = dateFormat.parse("05/28/2008");
		newBook.setPublishTime(publishDate);
		
		String imagePath = "C:\\Users\\piyus\\Desktop\\BookStoreWebsite Images\\Java_8_in_Action.JPG";
		
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newBook.setImage(imageBytes);
		
		Book createBook = bookDao.create(newBook);
		
		assertTrue(createBook.getBookId() > 0);
	}
	
	
	@Test
	public void testCreate3rdBook() throws ParseException, IOException {
		Book newBook = new Book();
		
		Category category = new Category("Advance Java");
		category.setCategoryId(2);
		newBook.setCategory(category);
		
		newBook.setTitle("Python 8 in Action");
		newBook.setAuthor("Alan Mycroft");
		newBook.setDescription("Java 8 in Action is a clearly written guide to the new Features of java 8");
		newBook.setPrice(36.72f);
		newBook.setIsbn("161591994");
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate = dateFormat.parse("05/28/2008");
		newBook.setPublishTime(publishDate);
		
		String imagePath = "C:\\Users\\piyus\\Desktop\\BookStoreWebsite Images\\Java_8_in_Action.JPG";
		
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newBook.setImage(imageBytes);
		
		Book createBook = bookDao.create(newBook);
		
		assertTrue(createBook.getBookId() > 0);
	}
	
	@Test
	public void testListNewbooks() {
		List<Book> listNewBooks = bookDao.listNewBooks();
		for(Book aBook : listNewBooks) {
			System.out.println(aBook.getTitle() + " - " + aBook.getPublishTime());
		}
		
		assertEquals(4, listNewBooks.size());
	}
	
	@Test
	public void testListByCategory() {
		int categoryId = 2;
		
		List<Book> listBooks = bookDao.listByCategory(categoryId);
		
		assertTrue(listBooks.size() > 0);
		
	}

}
