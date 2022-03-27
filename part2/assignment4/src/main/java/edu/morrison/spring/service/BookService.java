package edu.morrison.spring.services;

import java.util.List;

import edu.morrison.spring.beans.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BookService  {

  List<Book> findAll();
  Book findById(Long id);
  Book save(Book book);
  Page<Book> findAllByPage(Pageable pageable);

}

