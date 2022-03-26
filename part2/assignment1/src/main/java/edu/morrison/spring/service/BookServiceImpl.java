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
import javax.persistence.NoResultException;

import edu.morrison.spring.beans.Author;
import edu.morrison.spring.beans.Book;
import edu.morrison.spring.beans.Category;


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
    try {
      return query.getSingleResult();
    } catch (NoResultException ignore) {
      return null;
    }
	}

	@Transactional(readOnly = true)
  @Override
  public Category findCategoryByName(String name) {
		TypedQuery<Category> query = em.createNamedQuery("Category.findCategoryByName",
                                                     Category.class);
    query.setParameter("name", name);
    try {
      return query.getSingleResult();
    } catch (NoResultException ignore) {
      return null;
    }
	}

	@Transactional(readOnly = true)
  @Override
  public Author findAuthorByName(String firstName, String lastName) {
		TypedQuery<Author> query = em.createNamedQuery("Author.findAuthorByName",
                                                     Author.class);
    query.setParameter("first_name", firstName);
    query.setParameter("last_name", lastName);
    try {
      return query.getSingleResult();
    } catch (NoResultException ignore) {
      return null;
    }
  }


  @Override
	public Book save(Book book) {
		logger.info("Saving book with id: " + book.getId());

    Category cat = findCategoryByName(book.getCategory().getName());
    book.setCategory(cat);

    for (Author author : book.getAuthors()) {
      Author dbauth = findAuthorByName(author.getFirstName(), author.getLastName());
      if (dbauth == null) {
        em.persist(author);
        dbauth = findAuthorByName(author.getFirstName(), author.getLastName());
      }

      author.setId(dbauth.getId());
      if (author.getId() == null) {
        em.persist(author);
      } else {
        em.merge(author);
      }
    }

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
    for (Author author : mergedBook.getAuthors()) {
      em.remove(author);
    }
    em.remove(mergedBook);
    em.flush();

		logger.info("Book deleted with id: " + book.getId());
	}

}
