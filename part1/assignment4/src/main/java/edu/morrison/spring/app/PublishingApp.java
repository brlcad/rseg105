package edu.morrison.spring.app;

import java.util.concurrent.ThreadLocalRandom;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import edu.morrison.spring.beans.Book;
import edu.morrison.spring.beans.Category;
import edu.morrison.spring.config.AppConfig;
import edu.morrison.spring.dao.BookDao;
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
      demoLookupBook();
    if (demo == 0 || demo == 2)
      demoLookupAllBooks();
    if (demo == 0 || demo == 3)
      demoModifyingBook();
    if (demo == 0 || demo == 4)
      demoDeletingBook();

    logger.info("============== End of Publishing Demo =======================");

  }

  private static void demoDeletingBook() {
    logger.info("------- Demo 4: Deleting a book -------------------------------");

    logger.info("Programming books BEFORE delete:");

		BookDao bookDao = ctx.getBean(BookDao.class);

		Long idDelete = 8L;
		Book bookDelete = bookDao.findBookWithAuthorAndCategoryById(idDelete);
		bookDao.delete(bookDelete);
    /*		FindAllWithAlbumAndInstrumentDemo.listBooksWithAuthorAndCategory(
          bookDao.findAllWithAuthorAndCategory());
    */

		ctx.close();

    //logger.info("Programming books AFTER delete:");
  }


  private static void demoModifyingBook() {
    logger.info("------- Demo 3: Modifying a book -------------------------------");

    logger.info("Programming books BEFORE modify:");

    /* TODO */

    logger.info("Programming books AFTER modify:");
  }


  private static void demoAddingBook() {
    logger.info("------- Demo 2: Adding a book ----------------------------------");

    logger.info("Programming books BEFORE add:");

    Book book = new Book();
    book.setIsbn("978-0367505035");
    book.setTitle("Fundamentals of Computer Graphics");
    book.setPrice(126.0F);

    /* TODO */

    logger.info("Programming books AFTER add:");
  }


  private static void demoLookupAllBooks() {
    logger.info("------- Demo 2: Listing all books by author ID ------------------");

		BookDao bookDao = ctx.getBean(BookDao.class);

    Long id = 3L;
    logger.info("Looking up author ID: " + id);
    List<Book> books = bookDao.findAllBooksByAuthorId(id);
    books.forEach(i -> printBook(i));
    ctx.close();
  }


  private static void demoLookupBook() {
    logger.info("------- Demo 1: Printing books and categories ------------------");

		BookDao bookDao = ctx.getBean(BookDao.class);

    Long id = ThreadLocalRandom.current().nextLong(1L, 8L);
    logger.info("Looking up book ID: " + id);
    Book bookById = bookDao.findBookWithAuthorAndCategoryById(id);
    printBook(bookById);

    ctx.close();
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


  private static void printCategories() {
    /* TODO */
  }
}
