package edu.morrison.spring.dao;

import java.util.List;

import edu.morrison.spring.beans.Author;


public interface AuthorDao {
  Author save(Author author);

  List<Author> findAllAuthors();

  void delete(Author author);
}
