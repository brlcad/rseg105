package edu.morrison.spring.app;

import edu.morrison.spring.beans.Book;
import edu.morrison.spring.dao.BookDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class FindBookCategoryJdbcApp {
  //    private static CategoryDao categoryDao = new CategoryDao();
  //    private static Logger logger = LoggerFactory.getLogger(FindBookCategoryJdbcDemo.class);

    public static void main(String... args) {
        logger.info("Searching for book category:");

        /*
        // find all books by category name
        listAllCategories();

        // add and save a new book with a category name

        // update some data describing this book

        // delete this book

        logger.info("-------------");
        logger.info("Insert a new category");

        Category category = new Category();
        category.setId(5);
        category.setName("Fiction");
        categoryDao.insert(category);

        logger.info("Listing category data after new category created:");

        listAllCategories();

        logger.info("-------------");
        logger.info("Deleting the previous created category");

        categoryDao.delete(category.getId());

        logger.info("Listing category data after new category deleted:");

        listAllCategories();
        */
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
