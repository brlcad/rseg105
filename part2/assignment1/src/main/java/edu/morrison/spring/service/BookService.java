package edu.morrison.spring.service;

import java.util.List;

import edu.morrison.spring.beans.Book;


public interface BookService {

  Book save(Book book);

  /*
  List<Book> findAll();

  List<Book> findAllBooksByAuthorId(Long id);
  */

  Book findBookWithAuthorAndCategoryById(Long id);

  void delete(Book book);
}
