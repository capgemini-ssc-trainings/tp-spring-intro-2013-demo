package app.shared.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name="READER")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "LOGIN" }))
public class Reader implements Serializable {

	private static final long serialVersionUID = 320712227811453217L;

	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;

	@Column(name = "LOGIN", nullable = false)
	private String login;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@OneToMany(mappedBy = "currentReader")
	private Set<Book> books = new HashSet<Book>();
	
	public long getId() {
		return id;
	}

	public Reader() {

	}

	public Reader(Long id, String login, String firstName, String lastName) {
		super();
		this.id = id;
		this.login = login;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Book> getBooks() {
		return books;
	}
}
