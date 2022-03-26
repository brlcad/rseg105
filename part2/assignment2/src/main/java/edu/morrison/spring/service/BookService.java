package edu.morrison.spring;

import java.util.List;

import edu.morrison.spring.beans.Book;
import edu.morrison.spring.beans.Author;
import edu.morrison.spring.beans.Category;


public interface BookService  {

  List<Book> findAll();
  //  List<Author> findAuthor(Long id);

  List<Book> findBookWithAuthorAndCategoryById(Long id);

  Book save(Book book);

  /*
  void delete(Book book);
  */

}
