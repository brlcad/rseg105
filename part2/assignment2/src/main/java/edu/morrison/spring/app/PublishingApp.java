
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
import edu.morrison.spring.service.BookService;


public class PublishingApp {

  private static Logger logger = LoggerFactory.getLogger(PublishingApp.class);
  private static GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
  private static BookService bookService;

  public static void main(String... args) {

    ctx.load("classpath:spring/app-context-annotation.xml");
    ctx.refresh();
    bookService = ctx.getBean(BookService.class);

    Integer demo = 0; /* default is all of them */

    logger.info("Book Publishing Spring Data JPA2 Demo");
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
    logger.info("------- Demo 4: Find all books for one author id who has more than one book");

    /* author #1 has multiple books */
    logger.info("  listing books by author #1...");
    Long id = 1L;
    List<Book> books = bookService.findAllBooksByAuthorId(id);
    for(Book b : books) {
      printBook(b);
    }
    logger.info("  ... end listing of books by author #1");
  }


  private static void demoDeleteBook() {
    logger.info("------- Demo 3: Delete a saved book and author(s) from the database");

    Long id = 10L;
    Book bookById = bookService.findBookWithAuthorAndCategoryById(id);
    if (bookById != null) {
      logger.info("  found book #10...");
      printBook(bookById);
      bookService.delete(bookById);
    } else {
      return;
    }

    bookById = bookService.findBookWithAuthorAndCategoryById(id);
    if (bookById == null) {
      logger.info("  ...successfully deleted book #10");
    } else {
      logger.info("  ...unsuccessfully deleted book #10");
    }
  }


  private static void demoCreateBook() {
    logger.info("------- Demo 2: Create a new book with a new author(s)");

    Book newbook = new Book();
    newbook.setIsbn("978-0367505035");
    newbook.setTitle("Fundamentals of Computer Graphics");
    newbook.setPrice(126.0F);

    Category newcat = new Category();
    newcat.setName("Programming");
    newbook.setCategory(newcat);

    Author newauthor = new Author();
    newauthor.setFirstName("Peter");
    newauthor.setLastName("Shirley");
    newauthor.setDescription("Peter Shirley is computer graphics researcher, NVIDIA computer scientist, and University of Utah adjunct professor.");

    Set<Author> authors = new HashSet<>();
    authors.add(newauthor);
    newbook.setAuthors(authors);

    bookService.save(newbook);

    logger.info("  ...successfully added book");
  }


  private static void demoLookupBook() {
    logger.info("------- Demo 1: Find a book by id");

    Long id = 9L;
    Book bookById = bookService.findBookWithAuthorAndCategoryById(id);
    printBook(bookById);
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
