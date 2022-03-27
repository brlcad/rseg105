package edu.morrison.spring.services;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.google.common.collect.Lists;

import edu.morrison.spring.beans.Book;
import edu.morrison.spring.repository.BookRepository;


@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {

  //@Autowired
	private BookRepository bookRepository;

	@Override
  @Transactional(readOnly=true)
  public List<Book> findAll() {
    return Lists.newArrayList(bookRepository.findAll());
  }

	@Override
  @Transactional(readOnly=true)
  public Book findById(Long id) {
    return bookRepository.findById(id).get();
  }

	@Override
  public Book save(Book book) {
    return bookRepository.save(book);
  }


  @Autowired
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Book> findAllByPage(Pageable pageable) {
		return bookRepository.findAll(pageable);
	}

}
