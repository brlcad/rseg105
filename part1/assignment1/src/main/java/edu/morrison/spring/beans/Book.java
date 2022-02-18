package edu.morrison.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("book")
public class Book {

  private Long id = 0L;
  private String isbn = "";
  private String title = "";
  private Float price = 0.0F;

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
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
    return "This is a test";
  }

}
