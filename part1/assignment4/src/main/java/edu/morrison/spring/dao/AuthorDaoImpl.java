package edu.morrison.spring.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import edu.morrison.spring.beans.Author;


@Transactional
@Repository("authorDao")
public class AuthorDaoImpl implements AuthorDao {

  private static final Log logger = LogFactory.getLog(AuthorDaoImpl.class);
	private SessionFactory sessionFactory;

	@Override public Author save(Author author) {
		sessionFactory.getCurrentSession().saveOrUpdate(author);
		logger.info("Author saved with id: " + author.getId());
		return author;
	}

	public void delete(Author author) {
		sessionFactory.getCurrentSession().delete(author);
		logger.info("Author deleted with id: " + author.getId());
	}

	@Transactional(readOnly = true)
  public List<Author> findAllAuthors() {
    return (List<Author>) sessionFactory.getCurrentSession().
      getNamedQuery("Author.findAllAuthors").list();
  }

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
