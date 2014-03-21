package app.server;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import app.shared.model.Book;
import app.shared.service.BookSearchCriteria;
import app.shared.service.IBookService;


public class TestClient {

	final static Logger logger = LoggerFactory.getLogger(TestClient.class);

	public static void main(String[] args) {
		logger.info("TestClient started");

		//[ Aufgabe 1.6
		GenericXmlApplicationContext context = new GenericXmlApplicationContext ();
		context.getEnvironment().setActiveProfiles("mysql");
		context.load("/app/server/bean-definitions.xml");
		context.refresh();
		//] Aufgabe 1.6  Define application context

		//[ Aufgabe 1.7
		IBookService bean = context.getBean("bookService", IBookService.class);
		//] Aufgabe 1.7  Receive the bookService from the application context
		
		BookSearchCriteria criteria = new BookSearchCriteria();
		criteria.setPublicationYear(2007);
		//[ Aufgabe 1.8
		List<Book> books = bean.findBySearchCriteria(criteria);
		//] Aufgabe 1.8  Read books - List<Book> books = null;

		if (books != null) {
			logger.info("The following books have been found:");
			for (Book book : books) {
				logger.info(book.getAuthor() + ": \"" + book.getTitle() + "\"");
			}
		}
	}
}
