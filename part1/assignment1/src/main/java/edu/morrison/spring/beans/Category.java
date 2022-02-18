public class Category {
  private Long id;
  private String name;
  private Set<Book> booksSet;
  private List<Book> booksList;
  private Map<Book> booksMap;

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Set<Book> getBooksSet() {
    return booksSet;
  }
  public void setBooksSet(Set<Book> booksSet) {
    this.booksSet = booksSet;
  }
  public List<Book> getBooksList() {
    return booksList;
  }
  public void setBooksList(List<Book> booksList) {
    this.booksList = booksList;
  }
  public Map<Book> getBooksMap() {
    return booksMap;
  }
  public void setBooksMap(List<Book> booksMap) {
    this.booksMap = booksMap;
  }
}
