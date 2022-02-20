package edu.morrison.spring.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import edu.morrison.spring.beans.Category;


@Transactional
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

  private static final Log logger = LogFactory.getLog(CategoryDaoImpl.class);
	private SessionFactory sessionFactory;

	@Override public Category save(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		logger.info("Category saved with id: " + category.getId());
		return category;
	}

	@Transactional(readOnly = true)
    public Category findCategoryWithAuthorAndBooksById(Long id) {
		return (Category) sessionFactory.getCurrentSession().
				getNamedQuery("Category.findBooksWithAuthorCategoryById").
				setParameter("id", id).uniqueResult();
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
