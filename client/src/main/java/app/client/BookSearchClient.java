package app.client;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import app.shared.model.Book;
import app.shared.service.BookSearchCriteria;
import app.shared.service.IBookService;

public class BookSearchClient {
	public static void main(String[] args) {
		//[ Aufgabe 8.3
		GenericXmlApplicationContext context = new GenericXmlApplicationContext ();
		//context.getEnvironment().setActiveProfiles("microCloudFoundry");
		//context.getEnvironment().setActiveProfiles("cloudFoundry");
		context.load("app/client/client-config.xml");
		context.refresh();
		IBookService bookService = context.getBean(IBookService.class);
		//] Aufgabe 8.4  Obtain the BookService from app/client/client-config.xml - IBookService bookService = null;
		
		List<Book> list = bookService.findBySearchCriteria(new BookSearchCriteria());
		
		for (Book book : list) {
			System.out.println(book.getTitle());
		}
	}
}
