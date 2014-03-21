package app.server.dao;

import java.util.List;

import app.shared.model.Book;
import app.shared.service.BookSearchCriteria;

public interface IBookDao {
	List<Book> findBySearchCriteria(BookSearchCriteria searchCriteria);
	
	Book findById(Long bookId);
}
