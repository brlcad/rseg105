package edu.morrison.spring.beans;

import javax.persistence.*;

import edu.morrison.spring.beans.Category;


@Entity
@Table
public class Book extends AbstractEntity {

  @ManyToOne
  @JoinColumn(name = "CATEGORY_ID")
  private Category category;

  @Column
  private String isbn;

  @Column
  private String title;

  @Column
  private Float price;


  public Category getCategory() {
    return category;
  }
  public void setCategory(Category category) {
    this.category = category;
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
}
