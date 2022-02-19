package edu.morrison.spring.dao;

import javax.sql.DataSource;

import edu.morrison.spring.dao.CategoryDao;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.morrison.spring.app.MySQLErrorCodesTranslator;

//import java.util.HashMap;


public class JdbcCategoryDao implements CategoryDao, InitializingBean {

  private DataSource dataSource;
  private JdbcTemplate jdbcTemplate;

  @Autowired
  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;

    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    jdbcTemplate.setDataSource(dataSource);

    MySQLErrorCodesTranslator errorTrans = new MySQLErrorCodesTranslator();
    errorTrans.setDataSource(dataSource);
    jdbcTemplate.setExceptionTranslator(errorTrans);

    this.jdbcTemplate = jdbcTemplate;
  }


  @Override
  public String findBookByCategoryName(String name) {
    return jdbcTemplate.queryForObject("SELECT NAME FROM CATEGORY WHERE NAME = ?", new Object[]{name}, String.class);
  }


  @Override
  public void afterPropertiesSet() throws Exception {
    if (jdbcTemplate == null) {
      throw new BeanCreationException("Null JdbcTemplate on CategoryDao");
    }
  }
}
