package edu.morrison.spring.dao;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;

import edu.morrison.spring.dao.PublishingDao;
import edu.morrison.spring.beans.Category;
import edu.morrison.spring.beans.Book;


public class PublishingDaoImpl implements PublishingDao, InitializingBean {

  @Override
  public void afterPropertiesSet() throws Exception {
    /*
    if (hibernate == null) {
      throw new BeanCreationException("Null JdbcTemplate on PublishingDao");
    }
    */


    /*
     * at least one task should be developed with createQuery(…) method
     *
     * at least one task should be developed with getNamedQuery(…) without parameter(s).
     *
     * at least one task should be developed with getNamedQuery(…) with parameter(s).
     *
     * you may if you wish (i.e. not mandatory) to use Hibernate native queries in one of the functionality.
     *
     * you develop save and delete functionality using Hibernate.
     */
  }
}
