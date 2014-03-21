package app.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import app.server.dao.IBookDao;
import app.shared.model.Book;
import app.shared.service.BookSearchCriteria;
import app.shared.service.IBookService;

//[ Aufgabe 2.1
@Service("bookService")
//] Aufgabe 2.1  Configure with annotation. Bean name 'bookService'
public class BookService implements IBookService {

	//[ Aufgabe 4.9
	@Qualifier("hibernateBookDao")
	//] Aufgabe 4.9  Try to start the test client before implementing this step. What happens?. Choose the 'hibernateBookDao' implementation using @Qualifier annotation
	
	//[ Aufgabe 2.2
	@Autowired
	//] Aufgabe 2.2  inject BookDao using annotation
	
	//[ Aufgabe 1.3
	private IBookDao bookDao;
	//] Aufgabe 1.3  add a property to IBookDao bean

	//[ Aufgabe 1.4
	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}
	//] Aufgabe 1.4  add a setter method for the property

	//[ Aufgabe 4.5
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
	//] Aufgabe 4.5  Make the method transactional
	@Override
	@Cacheable(value="books")
	public List<Book> findBySearchCriteria(BookSearchCriteria searchCriteria) {
		//[ Aufgabe 1.5
		return bookDao.findBySearchCriteria(searchCriteria);
		//] Aufgabe 1.5  just invoke the DAO method using the property added - return null;
	}

	//[ Aufgabe 4.6
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
	//] Aufgabe 4.6  Make the method transactional
	@Override
	@CacheEvict(value="books", allEntries=true)
	public Book findById(Long bookId) {
		//[ Aufgabe 1.5
		return bookDao.findById(bookId);
		//] Aufgabe 1.5  just invoke the DAO method using the property added - return null;
	}
}
