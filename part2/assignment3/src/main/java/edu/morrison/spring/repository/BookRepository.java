package edu.morrison.spring.repository;

import edu.morrison.spring.beans.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

}
