package edu.morrison.spring.beans;

import java.io.Serializable;


public class Book implements Serializable {

  private Long id = 0L;
  private Long categoryId = 0L;
  private String isbn = "";
  private String title = "";
  private Float price = 0.0F;

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public Long getCategoryId() {
    return categoryId;
  }
  public void setCategoryId(Long id) {
    this.categoryId = id;
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
    	String s = "Book - Id: " + this.id + ", Category Id: " + this.categoryId + ", ISBN: " + this.isbn + ", Title: " + this.title + ", Price: "+ this.price;
    	return s;
  }

}
