package edu.morrison.spring.dao;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.morrison.spring.dao.CategoryDao;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import edu.morrison.spring.beans.Book;
import edu.morrison.spring.beans.Category;
import edu.morrison.spring.app.MySQLErrorCodesTranslator;


public class JdbcCategoryDao implements CategoryDao, InitializingBean {

  private static Logger logger = LoggerFactory.getLogger(JdbcCategoryDao.class);

  private DataSource dataSource;
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Autowired
  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;

    NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

    MySQLErrorCodesTranslator errorTrans = new MySQLErrorCodesTranslator();
    errorTrans.setDataSource(dataSource);
    // NamedParameterJdbcTemplates don't appear to have an exception translator
    //    jdbcTemplate.setExceptionTranslator(errorTrans);

    this.jdbcTemplate = jdbcTemplate;
  }


  @Override
  public List<Category> listCategories() {
    String query = "SELECT * FROM CATEGORY";
    return jdbcTemplate.query(query, (result, rowNum) -> {
        Category category = new Category();
        category.setId(result.getLong("ID"));
        category.setName(result.getString("NAME"));
        return category;
      });
  }


  @Override
  public List<Book> listBooksByCategoryName(String name) {
    String query = "SELECT * FROM BOOK,CATEGORY WHERE BOOK.CATEGORY_ID=CATEGORY.ID" + ((name == null) ? "" : " AND NAME = :name");

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
  }


  @Override
  public List<Book> listBooksByTitle(String title) {
    String query = "SELECT * FROM BOOK WHERE TITLE = :title";
    Map<String, Object> params = new HashMap<>();
    params.put("title", title);
    return jdbcTemplate.query(query, params, (result, rowNum) -> {
        Book book = new Book();
        book.setId(result.getLong("ID"));
        book.setCategoryId(result.getLong("CATEGORY_ID"));
        book.setIsbn(result.getString("ISBN"));
        book.setTitle(result.getString("TITLE"));
        book.setPrice(result.getFloat("PRICE"));
        return book;
      });
  }


  @Override
  public Long lookupCategoryIdByName(String name) {
    String query = "SELECT ID FROM CATEGORY WHERE NAME = :name LIMIT 1";
    Map<String, Object> params = new HashMap<>();
    params.put("name", name);
    return jdbcTemplate.queryForObject(query, params, Long.class);
  }


  @Override
  public void addBook(Book book, String category) {

    Long catId = 0L;
    try {
      catId = lookupCategoryIdByName(category);
    } catch (Exception e) {
      /* NOTE: ignoring unknown categories for now, but could add them
       * as a new category or throw an error back to the caller
       */
      logger.warn("Encountered unknown category [" + category + "]. Inserting uncategorized.");
    }

    Map<String, Object> params = new HashMap<>();
    params.put("CATEGORY_ID", catId);
    params.put("ISBN", book.getIsbn());
    params.put("TITLE", book.getTitle());
    params.put("PRICE", book.getPrice());
    jdbcTemplate.update("INSERT INTO BOOK (CATEGORY_ID, ISBN, TITLE, PRICE) values (:CATEGORY_ID, :ISBN, :TITLE, :PRICE)", params);
  }


  @Override
  public void updateBook(Book book) {
    Map<String, Object> params = new HashMap<>();
    params.put("ID", book.getId());
    params.put("CATEGORY_ID", book.getCategoryId());
    params.put("ISBN", book.getIsbn());
    params.put("TITLE", book.getTitle());
    params.put("PRICE", book.getPrice());
    jdbcTemplate.update("UPDATE BOOK SET CATEGORY_ID = :CATEGORY_ID, ISBN = :ISBN, TITLE = :TITLE, PRICE = :PRICE WHERE ID = :ID", params);
  }


  @Override
  public void deleteBook(Long id) {
    Map<String, Object> params = new HashMap<>();
    params.put("ID", id);
    jdbcTemplate.update("DELETE FROM BOOK WHERE ID = :ID", params);
  }


  @Override
  public void afterPropertiesSet() throws Exception {
    if (jdbcTemplate == null) {
      throw new BeanCreationException("Null JdbcTemplate on CategoryDao");
    }
  }
}
