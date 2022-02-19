package edu.morrison.spring.app;

import org.springframework.context.support.GenericXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import edu.morrison.spring.dao.CategoryDao;
import edu.morrison.spring.beans.Book;
import edu.morrison.spring.beans.Category;


public class FindBookCategoryJdbcApp {

  private static GenericXmlApplicationContext context = new GenericXmlApplicationContext();
  private static Logger logger = LoggerFactory.getLogger(FindBookCategoryJdbcApp.class);

  public static void main(String... args) {
    Integer step = 4;
    context.load("classpath:spring/app-context-xml.xml");
    context.refresh();

    logger.info("Find Book by Category Spring JDBC Demo");
    logger.info("v0.0.1 by C.S. Morrison");
    logger.info("");
    logger.info("Usage: " + args[0] + " [1234]");
    logger.info("");
    logger.info("This is a demonstration of reading and writing to a database using Spring JDBC.");
    logger.info("Specify a number to halt after each demo step in order to inspect the database.");
    logger.info("");

    if (args.length > 1) {
      step = Integer.parseInt(args[1]);
    }
    if (step < 0) {
      logger.error("Expecting no argument or step number after " + args[0]);
      return;
    }

    logger.info("============== Start of Find Books By Category =====================");

    if (step > 0)
      demoPrinting();
    if (step > 1)
      demoAddingBook();
    if (step > 2)
      demoModifyingBook();
    if (step > 3)
      demoDeletingBook();

    logger.info("============== End of Find Books By Category =====================");

    context.close();
  }


  private static void demoDeletingBook() {
    logger.info("------- Demo 1: Deleting a book -------------------------------");

    CategoryDao categoryDao = context.getBean(CategoryDao.class);

    logger.info("Programming books BEFORE delete:");
    printBooks("Programming");

    List<Book> books = categoryDao.listBooksByCategoryName("Programming");
    if (books.size() < 1) {
      logger.warn("Oops, something went horribly wrong getting a book to delete.");
      return;
    }
    /* assume we can update the last one */
    categoryDao.deleteBook(books.get(books.size()-1).getId());

    logger.info("Programming books AFTER delete:");
    printBooks("Programming");
  }


  private static void demoModifyingBook() {
    logger.info("------- Demo 3: Modifying a book -------------------------------");

    CategoryDao categoryDao = context.getBean(CategoryDao.class);

    logger.info("Programming books BEFORE modify:");
    printBooks("Programming");

    List<Book> books = categoryDao.listBooksByTitle("Fundamentals of Computer Graphics");
    if (books.size() < 1) {
      logger.warn("Oops, something went horribly wrong getting a book to delete.");
      return;
    }

    books.get(0).setTitle("Fundamentals of Computer Graphics, v5");
    books.get(0).setPrice(125.99F);

    categoryDao.updateBook(books.get(0));

    logger.info("Programming books AFTER modify:");
    printBooks("Programming");
  }


  private static void demoAddingBook() {
    logger.info("------- Step 2: Adding a book ----------------------------------");

    CategoryDao categoryDao = context.getBean(CategoryDao.class);

    logger.info("Programming books BEFORE add:");
    printBooks("Programming");

    Book book = new Book();
    book.setIsbn("978-0367505035");
    book.setTitle("Fundamentals of Computer Graphics");
    book.setPrice(126.0F);

    categoryDao.addBook(book, "Programming");

    logger.info("Programming books AFTER add:");
    printBooks("Programming");
  }


  private static void demoPrinting() {
    logger.info("------- Step 1: Printing books and categories ------------------");
    logger.info("All Books:");
    printBooks(null);

    logger.info("Poetry Books:");
    printBooks("Poetry");

    logger.info("All Categories:");
    printCategories();
  }


  private static void printBooks(String category) {
    CategoryDao categoryDao = context.getBean(CategoryDao.class);

    List<Book> books = categoryDao.listBooksByCategoryName(category);
    for (Book book: books) {
      logger.info("  " + book.toString());
    }
  }


  private static void printCategories() {
    CategoryDao categoryDao = context.getBean(CategoryDao.class);

    List<Category> categories = categoryDao.listCategories();
    for (Category category: categories) {
      logger.info("  " + category.getName());
    }
  }
}
