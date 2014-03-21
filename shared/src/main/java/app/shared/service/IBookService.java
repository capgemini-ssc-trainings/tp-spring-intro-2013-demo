package app.shared.service;

import java.util.List;

import app.shared.model.Book;

public interface IBookService {

	List<Book> findBySearchCriteria(BookSearchCriteria searchCriteria);

	Book findById(Long bookId);
}
