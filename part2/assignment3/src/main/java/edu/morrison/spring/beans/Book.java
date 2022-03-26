
package edu.morrison.spring.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

import edu.morrison.spring.beans.Category;
import edu.morrison.spring.beans.Author;


@Entity
@Table(name = "BOOK")
@NamedQueries({
		@NamedQuery(name=Book.FIND_ALL_BOOKS_BY_AUTHOR_ID,
                query="select distinct b from Book b " +
                "left join fetch b.authors a " +
                "left join fetch b.category c " +
                "where a.id = :id"
                ),
    @NamedQuery(name=Book.FIND_BOOK_WITH_AUTHOR_CATEGORY_BY_ID,
                query="select distinct b from Book b " +
                "left join fetch b.authors a " +
                "left join fetch b.category c " +
                "where b.id = :id"
                ),
    @NamedQuery(name=Book.FIND_BOOK_BY_TITLE,
                query="select distinct b from Book b " +
                "left join fetch b.authors a " +
                "left join fetch b.category c " +
                "where b.title = :title"
                )
  })
@SqlResultSetMapping(
     name="bookResult",
     entities=@EntityResult(entityClass=Book.class)
)
public class Book implements Serializable {

  /*
	public static final String FIND_ALL_BOOKS_BY_AUTHOR_ID = "Book.findAllBooksByAuthorId";
  public static final String FIND_BOOK_WITH_AUTHOR_CATEGORY_BY_ID = "Book.findBookWithAuthorCategoryById";
  public static final String FIND_BOOK_BY_TITLE = "Book.findBookByTitle";


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

  @ManyToOne
  @JoinColumn(name = "CATEGORY_ID")
  private Category category;

  @Column
  private String isbn;

  @Column
  private String title;

  @Column
  private Float price;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "AUTHOR_BOOK",
             joinColumns = @JoinColumn(name = "BOOK_ID"),
             inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
  private Set<Author> authors = new HashSet<>();


  public Category getCategory() {
    return this.category;
  }
  public void setCategory(Category category) {
    this.category = category;
  }

  public Set<Author> getAuthors() {
    return this.authors;
  }
  public void setAuthors(Set<Author> authors) {
    this.authors = authors;
  }

  public boolean setAuthor(Author author) {
    return getAuthors().add(author);
  }

  public String getIsbn() {
    return isbn;
  }
  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  public Float getPrice() {
    return price;
  }
  public void setPrice(Float price) {
    this.price = price;
  }


  @Override
  public String toString() {
    String s = "Book - Id: " + this.id + ", Category Id: " + this.category.getId() + ", ISBN: " + this.isbn + ", Title: " + this.title + ", Price: "+ this.price;
    return s;
  }

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		Book book = (Book) o;
		if (title != null ? !title.equals(book.title) : book.title != null)
			return false;
		return isbn != null ? isbn.equals(book.isbn) : book.isbn == null;
	}

	@Override public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
		return result;
	}
  */
}
