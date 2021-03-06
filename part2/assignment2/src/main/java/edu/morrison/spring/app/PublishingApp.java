
package edu.morrison.spring;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import edu.morrison.spring.beans.Book;
import edu.morrison.spring.beans.Author;
import edu.morrison.spring.beans.Category;


public class PublishingApp {

  private static Logger logger = LoggerFactory.getLogger(PublishingApp.class);
  private static GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();

  public static void main(String... args) {

    ctx.load("classpath:spring/app-context-annotation.xml");
    ctx.refresh();
    BookService bookService = ctx.getBean("springJpaBookService", BookService.class);

    Integer demo = 0; /* default is all of them */

    logger.info("Book Publishing Spring Data JPA2 Demo");
    logger.info("v0.0.1 by C.S. Morrison");
    logger.info("");
    logger.info("Usage: " + args[0] + "[1234]");
    logger.info("");
    logger.info("This is a demonstration of persisting entities via Spring Data JPA2.");
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
      demoLookupBook(bookService);
    if (demo == 0 || demo == 2)
      demoFindAllBooks(bookService);
    if (demo == 0 || demo == 3)
      demoCreateBook(bookService);
    if (demo == 0 || demo == 4)
      demoDeleteBook(bookService);

    logger.info("============== End of Publishing Demo =======================");

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


  private static void demoLookupBook(BookService bookService) {
    logger.info("------- Demo 1: Find a book by id");

    /* book #9 has multiple authors */
    Long id = 9L;
    List<Book> bookById = bookService.findBookWithAuthorAndCategoryById(id);
    printBook(bookById.get(0));
  }


  private static void demoFindAllBooks(BookService bookService) {
    logger.info("------- Demo 2: Find all books without details");

    List<Book> books = bookService.findAll();
    for(Book b : books) {
      logger.info(b.toString());
    }
  }

  private static void demoCreateBook(BookService bookService) {
    logger.info("------- Demo 3: Create a new book with a new author(s)");

    Book newbook = new Book();
    newbook.setIsbn("978-0367505035");
    newbook.setTitle("Fundamentals of Computer Graphics");
    newbook.setPrice(126.0F);

    Category newcat = new Category();
    newcat.setName("Programming");
    newcat.setId(3L);
    newbook.setCategory(newcat);

    Author newauthor = new Author();
    newauthor.setFirstName("Peter");
    newauthor.setLastName("Shirley");
    newauthor.setDescription("Peter Shirley is computer graphics researcher, NVIDIA computer scientist, and University of Utah adjunct professor.");

    Set<Author> authors = new HashSet<>();
    authors.add(newauthor);
    newbook.setAuthors(authors);

    bookService.save(newbook);

    logger.info("  ... looking up added book #10 ...");

    Long id = 10L;
    List<Book> bookById = bookService.findBookWithAuthorAndCategoryById(id);

    if (bookById != null) {
      logger.info("  book #10 FOUND:");
      printBook(bookById.get(0));
    } else {
      logger.info("  book #10 NOT found:");
    }
  }


  private static void demoDeleteBook(BookService bookService) {
    logger.info("------- Demo 4: Delete a saved book and author(s) from the database");

    List<Book> books;
    logger.info("  ... books before delete:");
    books = bookService.findAll();
    for(Book b : books) {
      logger.info(b.toString());
    }

    Long id = 10L;
    List<Book> bookById = bookService.findBookWithAuthorAndCategoryById(id);
    if (bookById != null) {
      logger.info("  ... deleting book #10 ...");
      bookService.delete(bookById.get(0));
    } else {
      logger.info("  ... book #10 does not exist, nothing to delete.");
      return;
    }

    logger.info("  ... books after delete:");
    books = bookService.findAll();
    for(Book b : books) {
      logger.info(b.toString());
    }

    logger.info("  ... confirming book #10 deleted ...");
    bookById = bookService.findBookWithAuthorAndCategoryById(id);
    if (bookById.size() == 0) {
      logger.info("  ... successfully deleted book #10");
    } else {
      logger.info("  ... unsuccessfully deleted book #10");
    }


  }

}
