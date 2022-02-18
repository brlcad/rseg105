package edu.morrison.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.HashSet;
import java.util.ArrayList;


@Component("category")
public class Category {

  private Long id = 0L;
  private String name = "Unknown";
  private Set<Book> booksSet = new HashSet<Book>();
  private List<Book> booksList = new ArrayList<Book>();
  private Map<String, Book> booksMap = Map.of();

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public Set<Book> getBooksSet() {
    return booksSet;
  }
  public void setBooksSet(Set<Book> booksSet) {
    this.booksSet = booksSet;
  }

  public List<Book> getBooksList() {
    return booksList;
  }
  public void setBooksList(List<Book> booksList) {
    this.booksList = booksList;
  }

  public Map<String, Book> getBooksMap() {
    return booksMap;
  }
  public void setBooksMap(Map<String, Book> booksMap) {
    this.booksMap = booksMap;
  }

  @Override
  public String toString() {
    return "This is also a test.";
  }

}
