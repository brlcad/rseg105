package edu.morrison.spring;

import java.util.List;

import edu.morrison.spring.beans.Book;


public interface BookService  {

  List<Book> findAll();
  Book findBookById(Long id);
  Book save(Book book);

}

