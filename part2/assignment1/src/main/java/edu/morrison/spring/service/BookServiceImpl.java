package edu.morrison.spring.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import edu.morrison.spring.beans.Book;


@Service("jpaBookService")
@SuppressWarnings("unchecked")
@Transactional
@Repository
public class BookServiceImpl implements BookService {

	private static final Log logger = LogFactory.getLog(BookServiceImpl.class);

  @PersistenceContext
	private EntityManager em;

  /*
  @Transactional(readOnly = true)
  @Override
  public List<Book> findAll() {
    return sessionFactory.getCurrentSession().createQuery("from Book b").list();
  }

	@Transactional(readOnly = true)
  @Override
	public List<Book> findAllBooksByAuthorId(Long id) {
		TypedQueryList<Book> books = em.createNamedQuery("Book.findAllBooksByAuthorId", Book.class).getResultList();

      setParameter("id", id).list();
	}
  */

	@Transactional(readOnly = true)
  @Override
  public Book findBookWithAuthorAndCategoryById(Long id) {
		TypedQuery<Book> query = em.createNamedQuery("Book.findBookWithAuthorCategoryById",
                                                 Book.class);
    query.setParameter("id", id);
    return query.getSingleResult();
	}

  @Override
	public Book save(Book book) {
    if (book.getId() == null) {
      em.persist(book);
    } else {
      em.merge(book);
    }
		logger.info("Book saved with id: " + book.getId());
		return book;
	}

  @Override
	public void delete(Book book) {
    Book mergedBook = em.merge(book);
    em.remove(mergedBook);

		logger.info("Book deleted with id: " + book.getId());
	}

}
