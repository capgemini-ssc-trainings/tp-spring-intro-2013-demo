package app.server;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import app.shared.model.Book;
import app.shared.service.BookSearchCriteria;
import app.shared.service.IBookService;

//[ Aufgabe 5.1
@RunWith(SpringJUnit4ClassRunner.class)
//] Aufgabe 5.1  Configure the SpringJUnit4ClassRunner
//[ Aufgabe 5.2
@ContextConfiguration(locations = { "classpath:/app/server/bean-definitions.xml" })
//] Aufgabe 5.2  Configure the context using /app/server/bean-definitions.xml
//@ActiveProfiles(profiles="mysql")
public class ServerTest {

	final Logger logger = LoggerFactory.getLogger(ServerTest.class);
	@Rule
	public TestName name = new TestName();

	//[ Aufgabe 5.3
	@Autowired
	//] Aufgabe 5.3  Inject the ApplicationContext using the @Autowired annotation
	private ApplicationContext applicationContext;

	//[ Aufgabe 5.4
	@Autowired
	//] Aufgabe 5.4  Inject the IBookService using the @Autowired annotation
	private IBookService bookService;
	
	@Test
	public void testFindBySearchCriteriaFromInjectedContext() {
		//[ Aufgabe 5.5
		IBookService bean = applicationContext.getBean("bookService",
				IBookService.class);
		//] Aufgabe 5.5  Obtain the IBookService from the application context
		BookSearchCriteria criteria = new BookSearchCriteria();
		criteria.setPublicationYear(2007);
		//[ Aufgabe 5.6
		List<Book> books = bean.findBySearchCriteria(criteria);
		//] Aufgabe 5.6  Read books using the bookService obtained from the context - List<Book> books = null;
		checkBooks(books);
	}


	

	@Test
	public void testFindBySearchCriteriaFromInjectedService() {
		BookSearchCriteria criteria = new BookSearchCriteria();
		criteria.setPublicationYear(2007);
		//[ Aufgabe 5.7
		List<Book> books = bookService.findBySearchCriteria(criteria);
		//] Aufgabe 5.7  Read books using the injected bookService - List<Book> books = null;
		checkBooks(books);
	}
	

	@Test
	public void testFindByIdFromInjectedContext() {
		//[ Aufgabe 5.8
		IBookService bean = applicationContext.getBean("bookService",
				IBookService.class);
		Book book = bean.findById(1L);
		Assert.assertNotNull(book);
		//] Aufgabe 5.8  (optional) implement like testFindBySearchCriteriaFromInjectedContext
	}
	

	@Test
	public void testFindByIdFromInjectedService() {
		//[ Aufgabe 5.9
		Book book = bookService.findById(1L);
		Assert.assertNotNull(book);
		//] Aufgabe 5.9  (optional) implement like testFindBySearchCriteriaFromInjectedService
	}

	@Before
	public void before() {
		logger.info("Starting the test method {}", name.getMethodName());
	}

	@After
	public void after() {
		logger.info("The test method {} finished", name.getMethodName());
	}
	
	private void checkBooks(List<Book> books) {
		Assert.assertEquals(1, books.size());

		if (books != null) {
			logger.info("The following books have been found:");
			for (Book book : books) {
				logger.info(book.getAuthor() + ": \"" + book.getTitle() + "\"");
			}
		}
	}
}
