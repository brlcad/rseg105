
package edu.morrison.spring.app;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import edu.morrison.spring.beans.Author;
import edu.morrison.spring.beans.Book;
import edu.morrison.spring.beans.Category;
import edu.morrison.spring.dao.AuthorDao;
import edu.morrison.spring.dao.BookDao;
import edu.morrison.spring.dao.CategoryDao;


public class PublishingApp {

  private static Logger logger = LoggerFactory.getLogger(PublishingApp.class);

  public static void main(String... args) {

    GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    ctx.load("classpath:spring/app-context-annotation.xml");
    ctx.refresh();

    Integer demo = 0; /* default is all of them */

    logger.info("Book Publishing JPA2 Demo");
    logger.info("v0.0.1 by C.S. Morrison");
    logger.info("");
    logger.info("Usage: " + args[0] + "[1234]");
    logger.info("");
    logger.info("This is a demonstration of persisting entities via Spring JPA2.");
    logger.info("Specify number to run each specific demo in succession (allowing database inspection).");
    logger.info("");

    if (args.length > 1) {
      demo = Integer.parseInt(args[1]);
    }
    if (demo < 0) {
      logger.error("Expecting no argument or demo number after " + args[0]);
      return;
    }

    logger.info("============== Start of Publishing Demo =====================");

    if (demo == 0 || demo == 1)
      demoLookupBook();
    if (demo == 0 || demo == 2)
      demoCreateBook();
    if (demo == 0 || demo == 3)
      demoDeleteBook();
    if (demo == 0 || demo == 4)
      demoFindAllBooks();

    logger.info("============== End of Publishing Demo =======================");

  }


  private static void demoFindAllBooks() {
    logger.info("------- Demo 4: Find all books for one author id who has more than one book in the database");


  }


  private static void demoDeleteBook() {
    logger.info("------- Demo 3: Delete a saved book and author(s) from the database");


  }


  private static void demoCreateBook() {
    logger.info("------- Demo 2: Create a new book with a new author(s)");


  }


  private static void demoLookupBook() {
    logger.info("------- Demo 1: Find all books for one author id who has more than one book");


  }

  private static void printBook(Book book) {
    logger.info(book.toString());
    Category category = book.getCategory();
    if (category != null)
      logger.info(category.toString());
    if (book.getAuthors() != null) {
      book.getAuthors().forEach(i -> logger.info(i.toString()));
    }
  }
}
