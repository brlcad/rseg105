package edu.morrison.spring.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import edu.morrison.spring.beans.Book;
import edu.morrison.spring.beans.Category;
import edu.morrison.spring.config.AppConfig;
import edu.morrison.spring.dao.CategoryDao;


public class PublishingApp {

  private static GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
  private static Logger logger = LoggerFactory.getLogger(PublishingApp.class);

  public static void main(String... args) {
    Integer demo = 0; /* default is all of them */

    logger.info("Book Publishing Hibernate Demo");
    logger.info("v0.0.1 by C.S. Morrison");
    logger.info("");
    logger.info("Usage: " + args[0] + "");
    logger.info("");
    logger.info("This is a demonstration of persisting entities via Spring Hibernate.");
    logger.info("Specify a number to only run one specific demo which allows database to be inspected.");
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
      demoPrinting();
    if (demo == 0 || demo == 2)
      demoAddingBook();
    if (demo == 0 || demo == 3)
      demoModifyingBook();
    if (demo == 0 || demo == 4)
      demoDeletingBook();

    logger.info("============== End of Publishing Demo =======================");

  }

  private static void demoDeletingBook() {
    logger.info("------- Demo 4: Deleting a book -------------------------------");

    logger.info("Programming books BEFORE delete:");
    printBooks("Programming");

    /* TODO */

    logger.info("Programming books AFTER delete:");
    printBooks("Programming");
  }


  private static void demoModifyingBook() {
    logger.info("------- Demo 3: Modifying a book -------------------------------");

    logger.info("Programming books BEFORE modify:");
    printBooks("Programming");

    /* TODO */

    logger.info("Programming books AFTER modify:");
    printBooks("Programming");
  }


  private static void demoAddingBook() {
    logger.info("------- Demo 2: Adding a book ----------------------------------");

    logger.info("Programming books BEFORE add:");
    printBooks("Programming");

    Book book = new Book();
    book.setIsbn("978-0367505035");
    book.setTitle("Fundamentals of Computer Graphics");
    book.setPrice(126.0F);

    /* TODO */

    logger.info("Programming books AFTER add:");
    printBooks("Programming");
  }


  private static void demoPrinting() {
    logger.info("------- Demo 1: Printing books and categories ------------------");
    logger.info("All Books:");
    printBooks(null);

    logger.info("Poetry Books:");
    printBooks("Poetry");

    logger.info("All Categories:");
    printCategories();

		CategoryDao categoryDao = ctx.getBean(CategoryDao.class);
    Category categoryById = categoryDao.findCategoryWithAuthorAndBooksById(1L);
    logger.info("FOUND CATEGORY 1: " + categoryById.toString());
    if (categoryById.getBooks() != null) {
      categoryById.getBooks().forEach(book -> logger.info("\t" + book.toString()));
    }
  }


  private static void printBooks(String category) {
    /* TODO */
  }


  private static void printCategories() {
    /* TODO */
  }
}
