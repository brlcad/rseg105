package edu.morrison.spring.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

import edu.morrison.spring.beans.Book;


@Entity
@Table(name = "CATEGORY")
@NamedQueries({
		@NamedQuery(name=Category.FIND_CATEGORY_BY_NAME,
                query="select distinct c from Category c " +
                "where c.name = :name"
                )
      })
public class Category implements Serializable {

  public static final String FIND_CATEGORY_BY_NAME = "Category.findCategoryByName";

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID")
	protected Long id;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

  @Column(unique = true)
  private String name;

  @OneToMany(mappedBy = "category", cascade=CascadeType.ALL, orphanRemoval=true)
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
