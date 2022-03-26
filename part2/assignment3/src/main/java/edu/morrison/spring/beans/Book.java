
package edu.morrison.spring.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;



@Entity
@Table(name = "BOOK")
public class Book implements Serializable {

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

  @Column(name = "CATEGORY_NAME")
  private String category;

  @Column
  private String isbn;

  @Column
  private String title;

  @Column
  private String publisher;

  @Column
  private Float price;


  public String getCategory() {
    return this.category;
  }
  public void setCategory(String category) {
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

  public String getPublisher() {
    return publisher;
  }
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public Float getPrice() {
    return price;
  }
  public void setPrice(Float price) {
    this.price = price;
  }


  @Override
  public String toString() {
    String s = "Book - Id: " + this.id + ", Category: " + this.category + ", ISBN: " + this.isbn + ", Title: " + this.title + ", Publisher: "+ this.publisher + ", Price: "+ this.price;
    return s;
  }

}
