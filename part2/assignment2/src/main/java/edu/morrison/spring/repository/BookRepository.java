package edu.morrison.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import edu.morrison.spring.beans.Book;
import edu.morrison.spring.beans.Author;
import edu.morrison.spring.beans.Category;


public interface BookRepository extends CrudRepository<Book, Long> {

  List<Book> findByTitle(String title);
  List<Book> findBookWithAuthorAndCategoryById(Long id);

}
