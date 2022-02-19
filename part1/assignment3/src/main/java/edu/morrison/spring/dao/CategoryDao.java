package edu.morrison.spring.dao;

import java.util.List;

import edu.morrison.spring.beans.Category;
import edu.morrison.spring.beans.Book;


public interface CategoryDao {

  public List<Category> listCategories();
  public List<Book> listBooksByCategoryName(String name);
  public List<Book> listBooksByTitle(String name);
  public Long lookupCategoryIdByName(String Name);

  public void addBook(Book book, String category);
  public void updateBook(Book book);
  public void deleteBook(Long id);

}
