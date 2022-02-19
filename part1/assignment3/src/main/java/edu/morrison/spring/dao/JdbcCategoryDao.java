package edu.morrison.spring.dao;

import javax.sql.DataSource;

import edu.morrison.spring.dao.CategoryDao;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import edu.morrison.spring.beans.Book;
import edu.morrison.spring.app.MySQLErrorCodesTranslator;


public class JdbcCategoryDao implements CategoryDao, InitializingBean {

  private DataSource dataSource;
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Autowired
  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;

    NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    //    jdbcTemplate.setDataSource(dataSource);

    MySQLErrorCodesTranslator errorTrans = new MySQLErrorCodesTranslator();
    errorTrans.setDataSource(dataSource);
    //    jdbcTemplate.setExceptionTranslator(errorTrans);

    this.jdbcTemplate = jdbcTemplate;
  }


  @Override
  public List<Book> findBookByCategoryName(String name) {
    String query = "SELECT * FROM BOOK,CATEGORY WHERE BOOK.CATEGORY_ID=CATEGORY.ID and NAME = :name";
    Map<String, Object> params = new HashMap<>();
    params.put("name", name);
    return jdbcTemplate.query(query, params, (result, rowNum) -> {
        Book book = new Book();
        book.setId(result.getLong("ID"));
        book.setCategoryId(result.getLong("CATEGORY_ID"));
        book.setIsbn(result.getString("ISBN"));
        book.setTitle(result.getString("TITLE"));
        book.setPrice(result.getFloat("PRICE"));
        return book;
      });
      //new Object[]{name}, Book.class);
  }


  @Override
  public void addBook(Book book) {
    Map<String, Object> params = new HashMap<>();
    params.put("CATEGORY_ID", book.getCategoryId());
    params.put("ISBN", book.getIsbn());
    params.put("TITLE", book.getTitle());
    params.put("PRICE", book.getPrice());
    jdbcTemplate.update("INSERT INTO BOOK (CATEGORY_ID, ISBN, TITLE, PRICE) values (:CATEGORY_ID, :ISBN, :TITLE, :PRICE)", params);
  }


  @Override
  public void afterPropertiesSet() throws Exception {
    if (jdbcTemplate == null) {
      throw new BeanCreationException("Null JdbcTemplate on CategoryDao");
    }
  }
}
