package edu.morrison.spring.beans;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import edu.morrison.spring.beans.Book;


@Entity
@Table
@NamedQueries({
    @NamedQuery(name=Category.FIND_BOOK_WITH_AUTHORS_CATEGORY_BY_ID,
                query="SELECT DISTINCT b FROM BOOK b " +
                "LEFT JOIN FETCH b.AUTHORS a " +
                "LEFT JOIN FETCH b.CATEGORY c " +
                "WHERE b.id = :id"
                )
      /* !!! need more */
  })
public class Category extends AbstractEntity {

  public static final String FIND_BOOK_WITH_AUTHORS_CATEGORY_BY_ID = "Category.findBookWithAuthorsCategoryById";

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
