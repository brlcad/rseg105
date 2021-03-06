package edu.morrison.spring.dao;

import java.util.List;

import edu.morrison.spring.beans.Book;


public interface BookDao {

  Book save(Book book);

  List<Book> findAllBooksByAuthorId(Long id);

  Book findBookWithAuthorAndCategoryById(Long id);

  Book findBookByTitle(String name);

  List<Book> findAll();

  void delete(Book book);
}
