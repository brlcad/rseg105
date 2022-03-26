package edu.morrison.spring.service;

import java.util.List;

import edu.morrison.spring.beans.Book;
/*
import edu.morrison.spring.beans.Author;
import edu.morrison.spring.beans.Category;
*/

public interface BookService  {

  List<Book> findAll();

  /*
  Book findBookWithAuthorAndCategoryById(Long id);
  Book save(Book book);
  void delete(Book book);

  Category findCategoryByName(String name);
  Author findAuthorByName(String firstName, String lastName);
  */

}
