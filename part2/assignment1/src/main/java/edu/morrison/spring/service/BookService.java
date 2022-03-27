package edu.morrison.spring.service;

import java.util.List;

import edu.morrison.spring.beans.Author;
import edu.morrison.spring.beans.Book;
import edu.morrison.spring.beans.Category;


public interface BookService {

  Book save(Book book);

  List<Book> findAll();
  List<Book> findAllBooksByAuthorId(Long id);
  Book findBookWithAuthorAndCategoryById(Long id);
  Category findCategoryByName(String name);
  Author findAuthorByName(String firstName, String lastName);

  void delete(Book book);
}
