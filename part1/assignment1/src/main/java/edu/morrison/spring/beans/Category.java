package edu.morrison.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.List;
import java.util.Map;


@Component("category")
public class Category {

  private Long id = 0;
  private String name = "Unknown";
  private Set<Book> booksSet = new Set<Book>();
  private List<Book> booksList = new List<Book>();
  private Map<String, Book> booksMap = new Map<String, Book>();

  public Long getId() {
    return id;
  }
  @Autowired
  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }
  @Autowired
  public void setName(String name) {
    this.name = name;
  }

  public Set<Book> getBooksSet() {
    return booksSet;
  }
  @Autowired
  public void setBooksSet(Set<Book> booksSet) {
    this.booksSet = booksSet;
  }

  public List<Book> getBooksList() {
    return booksList;
  }
  @Autowired
  public void setBooksList(List<Book> booksList) {
    this.booksList = booksList;
  }

  public Map<String, Book> getBooksMap() {
    return booksMap;
  }
  @Autowired
  public void setBooksMap(Map<String, Book> booksMap) {
    this.booksMap = booksMap;
  }

  @Override
  public String toString() {
    return "This is also a test.";
  }

}
