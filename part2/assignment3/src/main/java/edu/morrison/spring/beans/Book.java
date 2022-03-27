package edu.morrison.spring.beans;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "book")
public class Book implements Serializable {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "ID")
  private Long id;

  @Column(name = "CATEGORY_NAME")
  private String categoryName;

  @Column
  private String isbn;

  @Column
  private String title;

  @Column
  private String publisher;

  @Column
  private Float price;

  @Basic(fetch= FetchType.LAZY)
  @Lob
  @Column(name = "PHOTO")
  private byte[] photo;


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

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

  public byte[] getPhoto() {
    return photo;
  }

  public void setPhoto(byte[] photo) {
    this.photo = photo;
  }


  @Override
  public String toString() {
    String s = "Book - Id: " + this.id + ", Category: " + this.category + ", ISBN: " + this.isbn + ", Title: " + this.title + ", Publisher: "+ this.publisher + ", Price: "+ this.price;
    return s;
  }

}
