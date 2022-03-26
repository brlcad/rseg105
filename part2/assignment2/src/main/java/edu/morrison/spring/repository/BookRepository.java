import org.springframework.data.repository.CrudRepository;

import java.util.List;

import edu.morrison.spring.beans.Author;
import edu.morrison.spring.beans.Book;
import edu.morrison.spring.beans.Category;


public interface BookRepository extends CrudRepository<Book, Long> {

  List<Book> findByTitle(String title);

  /*
  Book findBookWithAuthorAndCategoryById(Long id);
  Book save(Book book);
  void delete(Book book);

  Category findCategoryByName(String name);
  Author findAuthorByName(String firstName, String lastName);
  */

}
