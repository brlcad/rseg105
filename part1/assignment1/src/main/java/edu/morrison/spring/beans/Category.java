package edu.morrison.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;


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
    String s = "";
    if (booksSet.size() > 0) {
      s += "==============Books Set Output Start ===============================\n";
      s += "Category -- Id: " + this.id + ", Name: " + this.name + ", Books List: [";

      Iterator i = booksSet.iterator();
      while (i.hasNext()) {
        Book b = (Book)i.next();
        s += b.toString();
        if (i.hasNext()) {
          s += ", ";
        }
      }
      s += "]\n";
      s += "==============Books Set Output End ===============================\n";
    }

    if (booksList.size() > 0) {
      s += "==============Books List Output Start ===============================\n";
      s += "Category -- Id: " + this.id + ", Name: " + this.name + ", Books List: [";
      Iterator i = booksList.iterator();
      while (i.hasNext()) {
        Book b = (Book)i.next();
        s += b.toString();
        if (i.hasNext()) {
          s += ", ";
        }
      }
      s += "]\n";
      s += "==============Books List Output End ===============================\n";
    }

    if (booksMap.size() > 0) {
      s += "==============Books Map Output Start ===============================\n";
      s += "Category -- Id: " + this.id + ", Name: " + this.name + ", Books List: [";
      Iterator i = booksMap.entrySet().iterator();
      while (i.hasNext()) {
        Map.Entry kv = (Map.Entry)i.next();
        String name = (String)kv.getKey();
        Book b = (Book)kv.getValue();
        s += b.toString();
        if (i.hasNext()) {
          s += ", ";
        }
      }
      s += "]\n";
      s += "==============Books Map Output End ===============================\n";
    }

    return s;
  }

}
