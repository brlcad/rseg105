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
  }
}
