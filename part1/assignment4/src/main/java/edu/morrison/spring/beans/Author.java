package edu.morrison.spring.beans;

import javax.persistence.*;


@Entity
@Table
public class Author extends AbstractEntity {

  @Column(name = "FIRST_NAME")
  private String firstName;

  @Column(name = "LAST_NAME")
  private String lastName;

  @Column
  private String description;

  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLasttName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  @ManyToMany
  @JoinTable(name = "AUTHOR_BOOK",
             joinColumns = @JoinColumn(name = "AUTHOR_ID"),
             inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
  private Set<Book> books = new HashSet<>();


  @Override
  public String toString() {
    String s = "Author - Id: " + this.id + ", First name: " + this.firstName + ", Last name: " + this.lastName + ", Description: " + this.description;
    return s;
  }

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		Author author = (Author) o;
		if (firstName != null ? !firstName.equals(author.firstName) : author.firstName != null)
			return false;
		if (lastName != null ? !lastName.equals(author.lastName) : author.lastName != null)
			return false;
		return description != null ? description.equals(author.description) : author.description == null;
	}

	@Override public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		return result;
}
