package edu.morrison.spring;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.google.common.collect.Lists;

import edu.morrison.spring.beans.Book;
/*
import edu.morrison.spring.beans.Author;
import edu.morrison.spring.beans.Category;
*/


@Service("springJpaBookService")
@Transactional
public class BookServiceImpl implements BookService {

  @Autowired
	private BookRepository bookRepository;

  @Transactional(readOnly = true)
  public List<Book> findAll() {
    return Lists.newArrayList(bookRepository.findAll());
  }

}
