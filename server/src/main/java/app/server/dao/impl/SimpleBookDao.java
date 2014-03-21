package app.server.dao.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import app.server.dao.IBookDao;
import app.shared.model.Book;
import app.shared.service.BookSearchCriteria;

//[ Aufgabe 2.1
@Repository("simpleBookDao")
//] Aufgabe 2.1  Configure with annotation. Bean name 'simpleBookDao'
public class SimpleBookDao implements IBookDao {

	@Override
	public List<Book> findBySearchCriteria(BookSearchCriteria searchCriteria) {
		Book book = new Book();
		book.setAuthor("G. King");
		book.setTitle("Hibernate in Action");
		book.setPublicationYear(2007);
		return Collections.singletonList(book);
	}

	@Override
	public Book findById(Long bookId) {
		Book book = new Book();
		book.setAuthor("G. King");
		book.setTitle("Hibernate in Action");
		book.setPublicationYear(2007);

		return book;
	}

}
