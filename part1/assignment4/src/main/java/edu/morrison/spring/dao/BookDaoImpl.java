package edu.morrison.spring.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import edu.morrison.spring.beans.Book;

@SuppressWarnings("unchecked")
@Transactional
@Repository("bookDao")
public class BookDaoImpl implements BookDao {

	private static final Log logger = LogFactory.getLog(BookDaoImpl.class);
	private SessionFactory sessionFactory;

	@Transactional(readOnly = true)
	public List<Book> findAllBooksByAuthorId(Long id) {
		return (List<Book>) sessionFactory.getCurrentSession().
      getNamedQuery("Book.findAllBooksByAuthorId").
      setParameter("id", id).list();
	}

	@Transactional(readOnly = true)
  public Book findBookWithAuthorAndCategoryById(Long id) {
		return (Book) sessionFactory.getCurrentSession().
      getNamedQuery("Book.findBookWithAuthorCategoryById").
      setParameter("id", id).uniqueResult();
	}

	public Book save(Book book) {
		sessionFactory.getCurrentSession().saveOrUpdate(book);
		logger.info("Book saved with id: " + book.getId());
		return book;
	}

	public void delete(Book book) {
		sessionFactory.getCurrentSession().delete(book);
		logger.info("Book deleted with id: " + book.getId());
	}

	//Inject the SessionFactory when SingerDaoImpl is initialized.
	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
