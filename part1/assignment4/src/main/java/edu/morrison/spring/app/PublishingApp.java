package edu.morrison.spring.app;

import java.util.concurrent.ThreadLocalRandom;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import edu.morrison.spring.beans.Author;
import edu.morrison.spring.beans.Book;
import edu.morrison.spring.beans.Category;
import edu.morrison.spring.config.AppConfig;
import edu.morrison.spring.dao.AuthorDao;
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
      demoAddingBook();
    if (demo == 0 || demo == 4)
      demoDeletingBook();

    logger.info("============== End of Publishing Demo =======================");

  }

  private static void demoDeletingBook() {
    logger.info("------- Demo 4: Deleting a book -------------------------------");

    logger.info("All books BEFORE delete:");

		BookDao bookDao = ctx.getBean(BookDao.class);

    List<Book> booksBefore = bookDao.findAll();
    booksBefore.forEach(i -> logger.info(i.toString()));

    String title = "Fundamentals of Computer Graphics";
    Book deleteme = bookDao.findBookByTitle(title);
    if (deleteme != null) {
      logger.info("Found our book to delete, id: " + deleteme.getId());
      printBook(deleteme);

      AuthorDao authorDao = ctx.getBean(AuthorDao.class);
      if (deleteme.getAuthors() != null)
        deleteme.getAuthors().forEach(i -> authorDao.delete(i));
      bookDao.delete(deleteme);

      logger.info("All books AFTER delete:");

      List<Book> booksAfter = bookDao.findAll();
      booksAfter.forEach(i -> logger.info(i.toString()));

    } else {
      logger.info("Book [" + title + "] not found");
    }

		ctx.close();
  }


  private static void demoAddingBook() {
    logger.info("------- Demo 3: Adding a book ----------------------------------");

    BookDao bookDao = ctx.getBean(BookDao.class);

    logger.info("All books BEFORE add:");

    List<Book> booksBefore = bookDao.findAll();
    booksBefore.forEach(i -> logger.info(i.toString()));

    Book book = new Book();
    book.setIsbn("978-0367505035");
    book.setTitle("Fundamentals of Computer Graphics");
    book.setPrice(126.0F);
    String programming = "Programming";
    CategoryDao categoryDao = ctx.getBean(CategoryDao.class);
    logger.info("Looking up category by name: " + programming);
    Category category = categoryDao.findCategoryByName(programming);
    logger.info(category.toString());
    book.setCategory(category);

    AuthorDao authorDao = ctx.getBean(AuthorDao.class);

    Set<Author> authors = new HashSet<Author>();
    Author author1 = new Author();
    author1.setFirstName("Steve");
    author1.setLastName("Marschner");
    author1.setDescription("Professor of Computer Science, Cornell University");
    authorDao.save(author1);
    Author author2 = new Author();
    author2.setFirstName("Peter");
    author2.setLastName("Shirley");
    author2.setDescription("American computer scientist and computer graphics researcher.");
    authorDao.save(author2);
    authors.add(author1);
    authors.add(author2);
    book.setAuthors(authors);

    logger.info("Adding book [" + book.getTitle() + "]");
    Book saved = bookDao.save(book);

    logger.info("All books AFTER add:");

    List<Book> booksAfter = bookDao.findAll();
    booksAfter.forEach(i -> logger.info(i.toString()));

    logger.info("Book actually written:");
    Book bookById = bookDao.findBookWithAuthorAndCategoryById(saved.getId());
    printBook(bookById);
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

}
