package edu.morrison.spring.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

import edu.morrison.spring.beans.Book;


@Entity
@Table(name = "CATEGORY")
public class Category extends AbstractEntity {

  @Column
  private String name;

  @OneToMany(mappedBy = "category", cascade=CascadeType.ALL,
             orphanRemoval=true)
  private Set<Book> books = new HashSet<>();

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public Set<Book> getBooks() {
    return books;
  }
  public void setBooks(Set<Book> books) {
    this.books = books;
  }

  @Override
  public String toString() {
    return String.format("Category - id: %d, Name: %s", id, name);
  }

}
