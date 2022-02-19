package edu.morrison.spring.dao;

import edu.morrison.spring.dao.CategoryDao;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

//import java.util.HashMap;


@Repository("categoryDao")
public class JdbcCategoryDao implements CategoryDao, InitializingBean {

  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Override
  public String findBookByCategoryName(String name) {
    return "";
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    if (namedParameterJdbcTemplate == null) {
      throw new BeanCreationException("Null NamedParameterJdbcTemplate on CategoryDao");
    }
  }
}
