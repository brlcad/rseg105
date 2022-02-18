package edu.morrison.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("book")
public class Book {

  private Long id;
  private String isbn;
  private String title;
  private Float price;

  public Long getId() {
    return id;
  }
  @Autowired
  public void setId(Long id) {
    this.id = id;
  }

  public String getIsbn() {
    return isbn;
  }
  @Autowired
  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }
  @Autowired
  public void setTitle(String title) {
    this.title = title;
  }

  public Float getPrice() {
    return price;
  }
  @Autowired
  public void setPrice(Float price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "This is a test";
  }

}
