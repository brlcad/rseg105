package edu.morrison.spring.app;

import org.springframework.context.support.GenericXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import edu.morrison.spring.dao.CategoryDao;
import edu.morrison.spring.beans.Book;


public class FindBookCategoryJdbcApp {

  private static Logger logger = LoggerFactory.getLogger(FindBookCategoryJdbcApp.class);

  public static void main(String... args) {
    GenericXmlApplicationContext context = new GenericXmlApplicationContext();
    context.load("classpath:spring/app-context-xml.xml");
    context.refresh();

    CategoryDao categoryDao = context.getBean(CategoryDao.class);

    List<Book> books = categoryDao.findBooksByCategoryName("Poetry");
    logger.info("Searching for book category:" + books);

    Book book = new Book();
    book.setIsbn("978-0367505035");
    book.setTitle("Fundamentals of Computer Graphics");
    book.setPrice(126.0F);

    categoryDao.addBook(book, "Programming");

    logger.info("Searching for book category:" + categoryDao.findBooksByCategoryName("Programming"));

    book.setTitle("Fundamentals of Computer Graphics, v5");
    book.setPrice(125.99F);

    categoryDao.updateBook(book);

    logger.info("Searching for book category:" + categoryDao.findBooksByCategoryName("Programming"));

    categoryDao.deleteBook(book.getId());

    logger.info("Searching for book category:" + categoryDao.findBooksByCategoryName("Programming"));

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
