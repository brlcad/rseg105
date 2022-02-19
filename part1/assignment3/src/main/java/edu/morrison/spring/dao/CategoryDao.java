package edu.morrison.spring.dao;

import java.util.List;
import edu.morrison.spring.beans.Book;

public interface CategoryDao {
  public List<Book> findBookByCategoryName(String name);

  public Long getCategoryID(String Name);

  public void addBook(Book book, String category);
}
