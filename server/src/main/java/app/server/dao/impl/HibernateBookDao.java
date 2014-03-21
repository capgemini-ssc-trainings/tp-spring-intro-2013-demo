package app.server.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.server.dao.IBookDao;
import app.shared.model.Book;
import app.shared.service.BookSearchCriteria;

//[ Aufgabe 4.7
@Repository("hibernateBookDao")
//] Aufgabe 4.7  Configure with annotation. Bean name 'hibernateBookDao'
public class HibernateBookDao implements IBookDao {

	//[ Aufgabe 4.8
	@Resource
	//] Aufgabe 4.8  Inject SessionFactory using @Resource or @Autowired annotation
	private SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Book> findBySearchCriteria(BookSearchCriteria searchCriteria) {
		Integer publicationYear = searchCriteria.getPublicationYear();
		String author = searchCriteria.getAuthor();
		String title = searchCriteria.getTitle();

		Criteria criteria = getCurrentSession().createCriteria(Book.class);
		if (null != publicationYear) {
			criteria = criteria.add(Restrictions.eq("publicationYear", publicationYear));
		}
		if (null != author && !author.isEmpty()) {
			criteria = criteria.add(Restrictions.eq("author", author));
		}
		if (null != title && !title.isEmpty()) {
			criteria = criteria.add(Restrictions.eq("title", title));
		}

		List<Book> list = criteria.list();

		return list;
	}

	@Override
	public Book findById(Long bookId) {
		return (Book) getCurrentSession().createCriteria(Book.class) //
				.add(Restrictions.eq("id", bookId)).uniqueResult();
	}

}
