package edu.morrison.spring.dao;

import java.util.List;

import edu.morrison.spring.beans.Book;


public interface BookDao {

  Book save(Book book);

  List<Book> findAllBooksByAuthorId(Long id);

  Book findBookWithAuthorAndCategoryById(Long id);

  void delete(Book book);
}
