package edu.morrison.spring.app;

import org.springframework.context.support.GenericXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

//import edu.morrison.spring.beans.;
import edu.morrison.spring.dao.CategoryDao;


public class FindBookCategoryJdbcApp {

  private static Logger logger = LoggerFactory.getLogger(FindBookCategoryJdbcApp.class);

  public static void main(String... args) {
    GenericXmlApplicationContext context = new GenericXmlApplicationContext();
    context.load("classpath:spring/app-context-xml.xml");
    context.refresh();

    CategoryDao categoryDao = context.getBean(CategoryDao.class);

    logger.info("Searching for book category:" + categoryDao.findBookByCategoryName("Poetry"));

        /*
        // find all books by category name

        // add and save a new book with a category name

        // update some data describing this book

        // delete this book
        */

    context.close();
  }


  /*
    private static void listAllCategories() {
        List<Category> categories = categoryDao.findAll();

        for (Category category: categories) {
            logger.info(category.toString());
        }
    }
  */
}
