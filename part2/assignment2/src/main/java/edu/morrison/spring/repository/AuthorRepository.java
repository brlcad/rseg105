package edu.morrison.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import edu.morrison.spring.beans.Book;
import edu.morrison.spring.beans.Author;
import edu.morrison.spring.beans.Category;


public interface AuthorRepository extends CrudRepository<Author, Long> {

}
