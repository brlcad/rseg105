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

	public Book save(Book book) {
		sessionFactory.getCurrentSession().saveOrUpdate(book);
		logger.info("Book saved with id: " + book.getId());
		return book;
	}

}
